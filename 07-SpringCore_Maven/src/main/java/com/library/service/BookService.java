package com.library.service;
import com.library.repository.BookRepository;

public class BookService {
    
    private BookRepository bookRepository;

    // Setter for Dependency Injection (Exercise 2)
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBooks() {
        System.out.println("BookService: Processing request...");
        bookRepository.fetchBooks();
        System.out.println("BookService: Books displayed successfully.");
    }
}