package cz.jiripinkas.jba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cz.jiripinkas.jba.entity.Configuration;
import cz.jiripinkas.jba.repository.ConfigurationRepository;

@Service
public class ConfigurationService {

	@Autowired
	private ConfigurationRepository configurationRepository;

	@Cacheable("configuration")
	public Configuration find() {
		List<Configuration> configurations = configurationRepository.findAll();
		if (configurations.size() == 0) {
			return null;
		} else if (configurations.size() > 1) {
			throw new UnsupportedOperationException("There can be only one configuration!");
		}
		return configurations.get(0);
	}

	@CacheEvict(value = "configuration", allEntries = true)
	public void saveIcon(byte[] bytes) {
		configurationRepository.saveIcon(bytes);
	}

	@CacheEvict(value = "configuration", allEntries = true)
	public void saveFavicon(byte[] bytes) {
		configurationRepository.saveFavicon(bytes);
	}

	@CacheEvict(value = "configuration", allEntries = true)
	public void saveAppleTouchIcon(byte[] bytes) {
		configurationRepository.saveAppleTouchIcon(bytes);
	}

	@CacheEvict(value = "configuration", allEntries = true)
	public void save(Configuration newConfiguration) {
		Configuration managedConfiguration = find();
		if (managedConfiguration != null) {
			newConfiguration.setId(managedConfiguration.getId());
		}
		configurationRepository.save(newConfiguration);
	}

}
