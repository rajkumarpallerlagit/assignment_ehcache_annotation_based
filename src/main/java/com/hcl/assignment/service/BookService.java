package com.hcl.assignment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hcl.assignment.model.AuthorBooks;
import com.hcl.assignment.model.Book;

@Service
public class BookService {

	private List<Book> mockBooks = new ArrayList<>();
	
	public BookService()
	{
		mockBooks.add(new Book("Author1Book1","publisher1",2021));
		mockBooks.add(new Book("Author1Book2","publisher2",2022));
		mockBooks.add(new Book("Author1Book3","publisher3",2023));
		
		mockBooks.add(new Book("Author2Book1","publisher1",2021));
		mockBooks.add(new Book("Author2Book2","publisher2",2022));
		mockBooks.add(new Book("Author2Book3","publisher3",2023));
	}

	@Cacheable(value = "booksCache", key="#author + '-' + #years")
	public AuthorBooks getBooks(String author, List<Integer> year) {

		System.out.println("Bookservice getbooks caching with author "+author +" year "+year);
		
		List<Book> books = mockBooks.stream().
				filter(book->book.getName().toLowerCase().contains(author.toLowerCase())).
				collect(Collectors.toList());
		
		books = books.stream().
				filter(book->year.contains(book.getYearPublished())).
				collect(Collectors.toList());
						
		
		return new AuthorBooks(author, books);
		
	}

}
