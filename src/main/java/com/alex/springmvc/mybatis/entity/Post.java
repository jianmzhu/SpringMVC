package com.alex.springmvc.mybatis.entity;

import java.io.Serializable;
import java.util.List;

public class Post  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1253207841156498024L;
	private int id;
	private Person person;
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	private String title;
	private String content;

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
}
