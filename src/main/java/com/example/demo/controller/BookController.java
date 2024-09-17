package com.example.demo.controller;

import com.example.demo.domein.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class BookController {

    @GetMapping("/getBook")
    public Book getBook() {
        Book book = new Book();
        book.setIsbn("978-90-430-4181-9");
        book.setTitle("Java voor studenten");
        book.setAuthor("Van den Broeck");
        return book;
    }

    // POST method to create a new Book object
    @PostMapping("/postBook")
    public Book createBook(@RequestBody Book book) {
        Book newBook = new Book();
        newBook.setIsbn(book.getIsbn());
        newBook.setTitle(book.getTitle());
        newBook.setAuthor(book.getAuthor());
        return newBook; // This will return the newly created book (just as an example)
    }

    @GetMapping("/getBooks")
    public ArrayList<Book> getBooks() {
        // use ArrayList to store the books
        ArrayList<Book> books = new ArrayList<>();
        Book book1 = new Book();
        book1.setIsbn("978-90-430-4181-9");
        book1.setTitle("Java voor studenten");
        book1.setAuthor("Van den Broeck");
        books.add(book1);
        Book book2 = new Book();
        book2.setIsbn("978-90-430-4181-9");
        book2.setTitle("Java voor studenten");
        book2.setAuthor("Van den Broeck");
        books.add(book2);
        return books;
    }

    @PostMapping("/postBooks")
    public ArrayList<Book> createBooks(@RequestBody ArrayList<Book> books) {
        // use ArrayList to store the books
        ArrayList<Book> newBooks = new ArrayList<>();
        for (Book book : books) {
            Book newBook = new Book();
            newBook.setIsbn(book.getIsbn());
            newBook.setTitle(book.getTitle());
            newBook.setAuthor(book.getAuthor());
            newBooks.add(newBook);
        }
        return newBooks; // This will return the newly created books (just as an example)
    }

    // get a single book from list by isbn that is received as a parameter
    @GetMapping("/getBookByIsbn")
    public Book getBookByIsbn(@RequestParam(value = "isbn") String isbn) {
        ArrayList<Book> books = new ArrayList<>();
        Book book1 = new Book();
        book1.setIsbn("978-90-430-4181-9");
        book1.setTitle("Java voor studenten");
        book1.setAuthor("Van den Broeck");
        books.add(book1);
        Book book2 = new Book();
        book2.setIsbn("978-90-430-4181-10");
        book2.setTitle("Java voor studenten");
        book2.setAuthor("Van den Broeck");
        books.add(book2);
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    // get a single book from list by isbn that is received as a bodyrequest via post method
    @PostMapping("/getBookByIsbn")
    public Book getBookByIsbnPost(@RequestBody String isbn) {
        ArrayList<Book> books = new ArrayList<>();
        Book book1 = new Book();
        book1.setIsbn("978-90-430-4181-9");
        book1.setTitle("Java voor studenten");
        book1.setAuthor("Van den Broeck");
        books.add(book1);
        Book book2 = new Book();
        book2.setIsbn("978-90-430-4181-10");
        book2.setTitle("Java voor studenten");
        book2.setAuthor("Van den Broeck");
        books.add(book2);
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                return b;
            }
        }
        return null;
    }
}
