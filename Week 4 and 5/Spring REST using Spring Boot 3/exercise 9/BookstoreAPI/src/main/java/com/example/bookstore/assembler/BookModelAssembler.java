package com.example.bookstore.assembler;

import com.example.bookstore.controller.BookController;
import com.example.bookstore.controller.AuthorController;
import com.example.bookstore.model.Book;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class BookModelAssembler extends RepresentationModelAssemblerSupport<Book, EntityModel<Book>> {

    public BookModelAssembler() {
        super(BookController.class, EntityModel.class);
    }

    @Override
    public EntityModel<Book> toModel(Book book) {
        return EntityModel.of(book,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(book.getId())).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks()).withRel("books"),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AuthorController.class).getAuthorById(book.getAuthor().getId())).withRel("author"));
    }
}
