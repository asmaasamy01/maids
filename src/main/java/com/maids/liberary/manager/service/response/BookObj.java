package com.maids.liberary.manager.service.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookObj {

	@JsonProperty(value = "bookId")
	private int id;
	@JsonProperty(value = "title")
	private String title;
	@JsonProperty(value = "author")
	private String author;
	@JsonProperty(value = "publicationYear")
	private Integer publicationYear;
	

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

	public Integer getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(Integer publicationYear) {
		this.publicationYear = publicationYear;
	}
}
