package com.example.bookstoreapi;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = new ArrayList<>();

    // Initialize with some sample data
    public BookController() {
        books.add(new Book(1L, "Effective Java", "Joshua Bloch", 45.00, "978-0134685991"));
        books.add(new Book(2L, "Clean Code", "Robert C. Martin", 40.00, "978-0132350884"));
    }

    // Get all books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "GetAllBooksHeader");
        return new ResponseEntity<>(books, headers, HttpStatus.OK);
    }

    // Get a book by ID with custom status if not found
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = books.stream()
                         .filter(b -> b.getId().equals(id))
                         .findFirst()
                         .orElse(null);

        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "GetBookByIdHeader");
        return new ResponseEntity<>(book, headers, HttpStatus.OK);
    }

    // Create a new book with custom status
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        books.add(book);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "CreateBookHeader");
        return new ResponseEntity<>(book, headers, HttpStatus.CREATED);
    }

    // Update an existing book with custom status and headers
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        Book book = books.stream()
                         .filter(b -> b.getId().equals(id))
                         .findFirst()
                         .orElse(null);

        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setPrice(updatedBook.getPrice());
        book.setIsbn(updatedBook.getIsbn());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "UpdateBookHeader");
        return new ResponseEntity<>(book, headers, HttpStatus.OK);
    }

    // Delete a book with custom status
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        boolean removed = books.removeIf(book -> book.getId().equals(id));

        if (!removed) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "DeleteBookHeader");
        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
    }
}
