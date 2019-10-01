package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Customer;
import com.sales.repositories.CustomerRepository;

/**
 * Customer service for interacting with Customer repository
 * @author Paul Kenny
 *
 */
@Service("CustomerService")
public class CustomerService {

	@Autowired
	private CustomerRepository repository;

	/**
	 * Add customer to database.
	 * @param customer Customer object to add.
	 * @return The saved entity.
	 */
	public Customer addCustomer(Customer customer) {
		return repository.save(customer);
	}

	/**
	 * Get all customers in database.
	 * @return Customers in repository.
	 */
	public ArrayList<Customer> getCustomers() {
		return (ArrayList<Customer>) repository.findAll();
	}

}