package com.hcl.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.assignment.model.AuthorBooks;
import com.hcl.assignment.service.BookService;
 
@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("me/books/list")
	public AuthorBooks getBooks(@RequestParam String author, 
			@RequestParam(required = false) List<Integer> year)
	{
		return bookService.getBooks(author, year);
	}

}