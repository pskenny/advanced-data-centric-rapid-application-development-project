package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Book;
import com.sales.repositories.BookRepository;

/**
 * Book service for interacting with Book repository
 * @author Paul Kenny
 *
 */
@Service("BookService")
public class BookService {

	@Autowired
	private BookRepository repository;

	/**
	 * Add book to database.
	 * @param book Book object to add.
	 * @return The saved entity.
	 */
	public Book addBook(Book book) {
		return repository.save(book);
	}

	/**
	 * Get all books in database.
	 * @return Books in repository.
	 */
	public ArrayList<Book> getBooks() {
		return (ArrayList<Book>) repository.findAll();
	}

}