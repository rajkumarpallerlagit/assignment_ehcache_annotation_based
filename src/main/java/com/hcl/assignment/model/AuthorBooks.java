package com.hcl.assignment.model;

import java.util.List;

public class AuthorBooks {
	private String author;
	private List<Book> books;
	
	public AuthorBooks(String author, List<Book> books) {
		super();
		this.author = author;
		this.books = books;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "AuthorBooks [author=" + author + "]";
	}
}
