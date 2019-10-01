package com.sales.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sales.models.Customer;

/**
 * Customer repository for accessing database.
 * @author Paul Kenny
 *
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	public Customer findBycid(String cid);
}
