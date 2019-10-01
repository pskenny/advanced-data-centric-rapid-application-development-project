package com.sales.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sales.models.Book;

/**
 * Book repository for accessing the database.
 * @author Paul Kenny
 *
 */
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	public Book findBybid(String bid);
}