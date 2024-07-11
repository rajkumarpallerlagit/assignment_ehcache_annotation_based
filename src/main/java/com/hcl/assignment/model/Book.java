package com.hcl.assignment.model;

public class Book {
	private String name;
	private String publisher;
	private Integer yearPublished;
	public Book(String name, String publisher, Integer yearPublished) {
		super();
		this.name = name;
		this.publisher = publisher;
		this.yearPublished = yearPublished;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Integer getYearPublished() {
		return yearPublished;
	}
	public void setYearPublished(Integer yearPublished) {
		this.yearPublished = yearPublished;
	}
	@Override
	public String toString() {
		return "Book [name=" + name + ", publisher=" + publisher + ", yearPublished=" + yearPublished + "]";
	}
}
