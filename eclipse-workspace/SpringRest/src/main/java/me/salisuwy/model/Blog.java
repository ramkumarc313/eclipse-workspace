package me.salisuwy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Blog {
	
    public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", content=" + content + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Blog(int id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}
	public Blog(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	private String title;
    private String content;


}
