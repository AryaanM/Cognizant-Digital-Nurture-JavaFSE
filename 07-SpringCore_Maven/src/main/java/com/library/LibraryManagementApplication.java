package com.library;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        
        System.out.println("--- Starting Spring Application Context ---");
        
        // Define the context as ClassPathXmlApplicationContext so we can close it later
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // Request the bean from the Spring container
        BookService service = (BookService) context.getBean("bookService");
        
        // Run the logic
        service.displayBooks();
        
        // FIX: Close the context to prevent the resource leak
        context.close();
        
        System.out.println("--- Execution Complete ---");
    }
}