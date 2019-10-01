package com.sales.controllers;

import java.util.Date;

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

import com.sales.exceptions.lIdException;
import com.sales.models.Loan;
import com.sales.services.LoanService;

/**
 * Controller for Loans. See
 * https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller for
 * design overview.
 * 
 * @author Paul Kenny
 *
 */
@Controller
public class LoanController {
	@Autowired
	@Qualifier("LoanService")
	LoanService loanService;

	/**
	 * Maps GET request for /showLoans
	 * 
	 * @param model Model for page
	 * @return JSP for listing loans
	 */
	@GetMapping(value = "/showLoans")
	public String getAllLoans(Model model) {
		// AllLoans model attribute iterated over to display loans in table on JSP page
		model.addAttribute("AllLoans", loanService.getLoans());
		// Returns showLoans.jsp (see webapp/jsp folder)
		return "showLoans";
	}

	/**
	 * Maps GET request for /addLoan
	 * 
	 * @param model Model for page
	 * @return JSP for adding loan
	 */
	@GetMapping(value = "/addLoan")
	public String getLoan(Model model) {
		// Create object and add to model for form
		Loan loan = new Loan();
		model.addAttribute("Loan", loan);
		// Returns showLoans.jsp (see webapp/jsp folder)
		return "addLoan";
	}

	/**
	 * Maps GET request for /addLoan
	 * 
	 * @param model Model for page
	 * @return JSP for adding loan
	 */
	@GetMapping(value = "/deleteLoan")
	public String deleteLoan(Model model) {
		// Create object and add to model for form
		Loan loan = new Loan();
		model.addAttribute("Loan", loan);
		// Returns showLoans.jsp (see webapp/jsp folder)
		return "showLoans";
	}

	/**
	 * Maps POST request for /addLoan
	 * 
	 * @param loan   Loan object to add to database
	 * @param result
	 * @return JSP page for new listings or errors
	 */
	@RequestMapping(value = "/addLoan", method = RequestMethod.POST)
	public String submitLoan(@Valid @ModelAttribute("Loan") Loan loan, BindingResult result, Model model) {
		// add date to loan, this is business logic, see project 
		// specification sections 5.7.2
		loan.setDueDate(new Date().toString());
		
		// Return to current page if errors occur
		if (result.hasErrors()) {
			return "addLoan";
		}

		try {
			// Add to loan service
			loanService.addLoan(loan);
		} catch (lIdException ex) {
			// Add model attributes used in errors
			model.addAttribute("error", ex.getMessage());
			return "addLoan";
		}
		
		// Redirect to showLoans.jsp
		return "redirect:showLoans";
	}

	/**
	 * Maps POST request for /deleteLoan
	 * 
	 * @param loan   Loan object to remove to database
	 * @param result
	 * @return JSP page for new listings or errors
	 */
	@RequestMapping(value = "/deleteLoan", method = RequestMethod.POST)
	public String deleteLoan(@Valid @ModelAttribute("Loan") Loan loan, BindingResult result, Model model) {
		try {
			// Remove from loan service
			loanService.removeLoan(loan);
		} catch (lIdException ex) {
			// Add model attributes used in errors
			model.addAttribute("error", ex.getMessage());
		}

		// Return to current page if errors occur
		if (result.hasErrors()) {
			return "deleteLoan";
		}
		// Redirect to showLoans.jsp
		return "redirect:showLoans";
	}
}