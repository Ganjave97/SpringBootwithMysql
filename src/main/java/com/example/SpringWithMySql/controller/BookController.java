package com.example.SpringWithMySql.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringWithMySql.model.Book;
import com.example.SpringWithMySql.repo.BookRepository;

@RestController
public class BookController {
	
	@Autowired
	BookRepository bookRepository;
	
	
	@PostMapping("/bookSave")
	public String insertBook(@RequestBody Book book) {
		bookRepository.save(book);
		return "your record is saved successfully ! !";
		
	}
	@PostMapping("/multipleBookSave")
	public String insertBook(@RequestBody List<Book> book) {
		bookRepository.saveAll(book);
		return "Record is saved successfully ! !";
		
	}
	
	@GetMapping("/getAllBook")
	public List<Book> getBook() {
		return (List <Book>) bookRepository.findAll();
		
		
	}
	
	@GetMapping("/getByBookName/{name}")
	public List<Book> getBookByName(@PathVariable("name") String bookName) {
		return (List<Book>) bookRepository.findBybookName(bookName);
	}
	
	
		@GetMapping("/getByBookId/{bookId}")
		public Optional<Book> getBookById (@PathVariable("bookId") Long id) {
			return bookRepository.findById(id); 
	}
		
	
}
