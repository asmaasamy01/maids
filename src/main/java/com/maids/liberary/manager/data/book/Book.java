package com.maids.liberary.manager.data.book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity
public class Book{
	@Id 
	@SequenceGenerator(name = "BOOK_GEN", sequenceName = "seq_book",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOK_GEN")
	private Long id;
	private String title;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Book(Long id, String title, String author, Integer publicationYear) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
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

	private String author;
	private Integer publicationYear;

public Book updateBook(String title,String author,Integer publicationYear){
	return new Book(this.id,title,author,publicationYear);
}

public Book() {
	
}

}
