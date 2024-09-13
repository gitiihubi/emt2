package com.iman.TestLibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iman.TestLibrary.entity.Book;
import com.iman.TestLibrary.service.BookService;


@Controller
@RequestMapping(value = "/api/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/list")
	@ResponseBody
	public List<Book> getListOfBooks() {
		return bookService.allBooks();
	}

	@PostMapping(value = "/create")
	@ResponseBody
	public Book addBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}

	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public ResponseEntity<String> deleteBook(@PathVariable long id) {
		if (bookService.existBook(id)) {
			bookService.deleteBookById(id);
			return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
		}
		return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
	}

	@PutMapping("/update/{id}")
	@ResponseBody
	public Book updateBook(@PathVariable long id, @RequestBody Book book) {

		return bookService.updateBook(id, book).orElseThrow(() -> {
			throw new BookNotFoundException();
		});
	}

}
