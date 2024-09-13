package com.iman.TestLibrary.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iman.TestLibrary.entity.Book;
import com.iman.TestLibrary.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;

	@Transactional
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	@Transactional
	public void deleteBookById(long id) {
		bookRepository.deleteById(id);
	}

	// @Transactional
	// public Book updateBook(long id, Book newBook) {
	// Book book = bookRepository.findById(id).get();
	// book.setTitle(newBook.getTitle());
	// return bookRepository.save(book);
	// }

	@Transactional
	public Optional<Book> updateBook(long id, Book newBook) {
		return bookRepository.findById(id).map(book -> {
			book.setTitle(newBook.getTitle());
			return bookRepository.save(book);
		});
	}

	public boolean existBook(long id) {
		if (bookRepository.existsById(id))
			return true;
		return false;
	}

	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
}
