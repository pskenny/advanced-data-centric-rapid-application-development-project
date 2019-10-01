package com.sales.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Book;
import com.sales.services.BookService;

/**
 * Controller for Books. See
 * https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller for
 * design overview.
 * 
 * @author Paul Kenny
 *
 */
@Controller
public class BookController {
	@Autowired
	@Qualifier("BookService")
	BookService bookService;

	/**
	 * Maps GET request for /showBooks
	 * 
	 * @param model Model for page
	 * @return JSP for listing books
	 */
	@GetMapping(value = "/showBooks")
	public String getAllBooks(Model model) {
		// AllBooks model attribute iterated over to display books in table on JSP page
		model.addAttribute("AllBooks", bookService.getBooks());
		// Returns showBooks.jsp (see webapp/jsp folder)
		return "showBooks";
	}

	/**
	 * Maps GET request for /addBook
	 * 
	 * @param model Model for page
	 * @return JSP for adding book
	 */
	@GetMapping(value = "/addBook")
	public String getBook(Model model) {
		// Create object and add to model for form to handle data
		Book book = new Book();
		model.addAttribute("Book", book);
		// Returns showBooks.jsp (see webapp/jsp folder)
		return "addBook";
	}

	/**
	 * Maps POST request for /addBook
	 * 
	 * @param book   Book object to add to database
	 * @param result Page to direct to
	 * @return JSP page for new listings or errors
	 */
	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public String submitBook(@Valid @ModelAttribute("Book") Book book, BindingResult result) {
		// Return to current page if errors occur
		if (result.hasErrors()) {
			return "addBook";
		}
		
		// Add to book service if no errors occur
		bookService.addBook(book);
		
		// Redirect to showBooks.jsp
		return "redirect:showBooks";
	}
}