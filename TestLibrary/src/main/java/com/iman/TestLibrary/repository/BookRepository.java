package com.iman.TestLibrary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iman.TestLibrary.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	List<Book> findByTitleContainingIgnoreCase(String title);

}
