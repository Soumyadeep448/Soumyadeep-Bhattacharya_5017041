package com.example.bookstore.controller;

import com.example.bookstore.assembler.BookModelAssembler;
import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;
    private final BookModelAssembler assembler;

    public BookController(BookService bookService, BookModelAssembler assembler) {
        this.bookService = bookService;
        this.assembler = assembler;
    }

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public EntityModel<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.findBookById(id);
        return assembler.toModel(book);
    }

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public CollectionModel<EntityModel<Book>> getAllBooks() {
        List<EntityModel<Book>> books = bookService.findAllBooks().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(books);
    }
}
