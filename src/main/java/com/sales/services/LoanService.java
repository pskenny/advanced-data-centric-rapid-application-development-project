package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.exceptions.lIdException;
import com.sales.models.Loan;
import com.sales.repositories.BookRepository;
import com.sales.repositories.CustomerRepository;
import com.sales.repositories.LoanRepository;

/**
 * Loan service for interacting with Loan repository
 * 
 * @author Paul Kenny
 *
 */
@Service("LoanService")
public class LoanService {

	@Autowired
	private LoanRepository repository;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private BookRepository bookRepository;

	/**
	 * Add loan to database.
	 * 
	 * @param loan Loan object to add.
	 * @return The saved entity.
	 */
	public Loan addLoan(Loan loan) throws lIdException {
		// check if lid is already present in repository
		Long cid = loan.getCust().getCid();
		Long bid = loan.getBook().getBid();
		
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		if(customerRepository.findBycid(cid.toString()) == null) {
			sb.append("No such customer: ");
			sb.append(bid);
		}
		
		if(bookRepository.findBybid(bid.toString()) == null) {
			sb.append("No such book: ");
			sb.append(bid);
		}
		
		if(flag) {
			throw new lIdException(sb.toString());
		}

		return repository.save(loan);
	}

	/**
	 * Remove loan from database.
	 * 
	 * @param loan Loan object to remove.
	 */
	public void removeLoan(Loan loan) throws lIdException {
		// check if lid is present in repository, delete on finding the same lid
		Long lid = loan.getLid();
		for (Loan iLoan : repository.findAll()) {
			if (lid == iLoan.getLid()) {
				repository.delete(iLoan);
			}
		}

		throw new lIdException("No such loan" + lid);
	}

	/**
	 * Get all loans in database.
	 * 
	 * @return Loans in repository.
	 */
	public ArrayList<Loan> getLoans() {
		return (ArrayList<Loan>) repository.findAll();
	}

}