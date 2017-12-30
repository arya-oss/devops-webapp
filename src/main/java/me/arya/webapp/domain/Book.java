package me.arya.webapp.domain;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String author;
	private Date published;

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPublished() {
		return published;
	}

	public void setPublished(Date published) {
		this.published = published;
	}
	
	@Override
	public String toString() {
		return "<Book: Title=" + title + ", published=" + published + ">";
	}
}
