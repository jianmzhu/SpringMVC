package com.alex.springmvc.rssmessage.example;

import java.util.Date;

/**
 * RSS的主体内容
 * 
 * @author xiaoming
 *
 */
public class RSSMessage {
	private String title;
	private String url;
	private String summary;
	private Date createdDate;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}