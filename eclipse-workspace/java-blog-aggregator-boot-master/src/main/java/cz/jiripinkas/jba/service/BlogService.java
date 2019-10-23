package cz.jiripinkas.jba.service;

import cz.jiripinkas.jba.entity.Blog;
import cz.jiripinkas.jba.entity.Item;
import cz.jiripinkas.jba.entity.User;
import cz.jiripinkas.jba.exception.PageNotFoundException;
import cz.jiripinkas.jba.repository.BlogRepository;
import cz.jiripinkas.jba.repository.ItemRepository;
import cz.jiripinkas.jba.repository.UserRepository;
import cz.jiripinkas.jba.util.MyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.*;

@Service
public class BlogService {

	private static final Logger log = LoggerFactory.getLogger(BlogService.class);

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RssService rssService;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ItemService itemService;

	@Autowired
	private BlogResultService blogResultService;

	private Date lastIndexedDateFinish;

	public void saveItems(Blog blog, Map<String, Object> allLinksMap, Map<String, Object> allLowercaseTitlesMap) {
		StringBuilder errors = new StringBuilder();
		try {
			List<Item> items = rssService.getItems(blog.getUrl(), blog, allLinksMap);
			for (Item item : items) {
				if (item.getError() != null) {
					errors.append(item.getError());
					errors.append(", ");
					continue;
				}
				if (!itemService.isTooOldOrYoung(item.getPublishedDate())) {
					// search for duplicities in the database
					boolean duplicate = false;
					if (allLinksMap.containsKey(item.getLink())) {
						duplicate = true;
					}
					// maybe the link is already in the database with https:// ?
					if (allLinksMap.containsKey(item.getLink().replace("http://", "https://"))) {
						duplicate = true;
					}
					// maybe the link is already in the database with http:// ?
					if (allLinksMap.containsKey(item.getLink().replace("https://", "http://"))) {
						duplicate = true;
					}
					if (Boolean.TRUE.equals(blog.getAggregator())
							&& allLowercaseTitlesMap.containsKey(item.getTitle().toLowerCase())) {
						duplicate = true;
					}
					if (!duplicate) {
						item.setSavedDate(new Date());
						item.setBlog(blog);
						itemRepository.save(item);
						// when I save something, I must set lastIndexedDate
						blogResultService.saveLastIndexedDate(blog);
						allLinksMap.put(item.getLink(), null);
						// break this loop, so that only single item is saved.
						break;
					}
				}
			}
			blogResultService.saveOk(blog);
		} catch (Exception e) {
			log.warn("Error downloading: " + blog.getUrl() + " message: " + e.getMessage());
			log.debug("Stacktrace", e);
			errors.append(e.getMessage());
		}
		if (errors.length() != 0) {
			blogResultService.saveFail(blog, errors.toString());
		}
	}

	public int getLastIndexDateMinutes() {
		if (lastIndexedDateFinish == null) {
			return 0;
		}
		return (int) ((new Date().getTime() - lastIndexedDateFinish.getTime()) / (1000 * 60));
	}

	@Caching(evict = { @CacheEvict(value = "blogCount", allEntries = true),
			@CacheEvict(value = "blogCountUnapproved", allEntries = true)})
	@Async
	public void save(Blog blog, String name) {
		User user = userRepository.findByName(name);
		blog.setUser(user);
		blog.setShortName(MyUtil.generatePermalink(blog.getShortName()));
		blogRepository.save(blog);
		saveItems(blog, new HashMap<String, Object>(), new HashMap<String, Object>());
	}

	@Transactional
	public void update(Blog blog, String username, boolean isAdmin) {
		blogRepository.findById(blog.getId()).ifPresent(managedBlog -> {
			if (!managedBlog.getUser().getName().equals(username) && !isAdmin) {
				throw new AccessDeniedException("user attempted to edit another user's blog");
			}
			managedBlog.setName(blog.getName());
			managedBlog.setShortName(blog.getShortName());
			managedBlog.setUrl(blog.getUrl());
			managedBlog.setHomepageUrl(blog.getHomepageUrl());
			managedBlog.setAggregator(blog.getAggregator());
			managedBlog.setNick(blog.getNick());
			managedBlog.setMinRedditUps(blog.getMinRedditUps());
			managedBlog.setArchived(blog.getArchived());
			blogRepository.save(managedBlog);
		});
	}

	@Caching(evict = { @CacheEvict(value = "blogCount", allEntries = true),
			@CacheEvict(value = "blogCountUnapproved", allEntries = true),
			@CacheEvict(value = "icons", allEntries = true) })
	@Transactional
	@PreAuthorize("#blog.user.name == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("blog") Blog blog) {
		blogRepository.delete(blog);
	}

	@Transactional
	public Blog findOne(int id) {
		Optional<Blog> optional = blogRepository.findById(id);
		return optional.orElse(null);
	}

	@Cacheable("icons")
	@Transactional
	public byte[] getIcon(int blogId) throws IOException {
		Optional<Blog> blog = blogRepository.findById(blogId);
		if(!blog.isPresent()) {
			throw new PageNotFoundException();
		} else {
			byte[] icon = blog.get().getIcon();
			if (icon == null) {
				return getClass().getResourceAsStream("/generic-blog.png").readAllBytes();
			}
			return icon;
		}
	}

	@Transactional
	public Blog findOne(String url) {
		return blogRepository.findByUrl(url);
	}

	@Transactional
	public Blog findOneFetchUser(int id) {
		return blogRepository.findOneFetchUser(id);
	}

	@Cacheable("blogCount")
	public long count() {
		return blogRepository.count();
	}
	
	@Cacheable("blogCountUnapproved")
	public long countUnapproved() {
		return blogRepository.countUnapproved();
	}

	public void setLastIndexedDateFinish(Date lastIndexedDateFinish) {
		this.lastIndexedDateFinish = lastIndexedDateFinish;
	}

	@CacheEvict(value = "icons", allEntries = true)
	public void saveIcon(int blogId, byte[] bytes) {
		blogRepository.saveIcon(blogId, bytes);
	}

	@Transactional
	public Blog findByShortName(String shortName) {
		return blogRepository.findByShortName(shortName);
	}

	/**
	 * Return list of blogs.
	 * 
	 * @param showAll
	 *            Whether all blogs should be returned, or just those, which are
	 *            enabled (have assigned category).
	 * @return
	 */
	@Transactional
	public List<Blog> findAll(boolean showAll) {
		if (showAll) {
			return blogRepository.findAllFetchUser();
		} else {
			return blogRepository.findAllWithCategoryFetchUser();
		}
	}

}