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

import com.sales.models.Customer;
import com.sales.services.CustomerService;

/**
 * Controller for Customers. See
 * https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller for
 * design overview.
 * 
 * @author Paul Kenny
 *
 */
@Controller
public class CustomerController {
	@Autowired
	@Qualifier("CustomerService")
	CustomerService customerService;

	/**
	 * Maps GET request for /showCustomers
	 * 
	 * @param model Model for page
	 * @return JSP for listing Customers
	 */
	@GetMapping(value = "/showCustomers")
	public String getAllCustomers(Model model) {
		// AllCustomers model attribute iterated over to display Customers in table on
		// JSP page
		model.addAttribute("AllCustomers", customerService.getCustomers());
		// Returns showCustomers.jsp (see webapp/jsp folder)
		return "showCustomers";
	}

	/**
	 * Maps GET request for /addCustomer
	 * 
	 * @param model Model for page
	 * @return JSP for adding Customer
	 */
	@GetMapping(value = "/addCustomer")
	public String getCustomer(Model model) {
		// Create object and add to model for form
		Customer customer = new Customer();
		model.addAttribute("Customer", customer);
		// Returns showCustomers.jsp (see webapp/jsp folder)
		return "addCustomer";
	}

	/**
	 * Maps POST request for /addCustomer
	 * 
	 * @param Customer Customer object to add to database
	 * @param result
	 * @return JSP page for new listings or errors
	 */
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public String submitCustomer(@Valid @ModelAttribute("Customer") Customer customer, BindingResult result) {
		// Return to current page if errors occur
		if (result.hasErrors()) {
			return "addCustomer";
		}
		
		// Add to Customer service
		customerService.addCustomer(customer);
		
		// Redirect to showCustomers.jsp
		return "redirect:showCustomers";
	}
}