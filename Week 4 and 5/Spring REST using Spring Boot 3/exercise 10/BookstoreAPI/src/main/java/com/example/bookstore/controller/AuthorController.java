package com.example.bookstore.controller;

import com.example.bookstore.assembler.AuthorModelAssembler;
import com.example.bookstore.model.Author;
import com.example.bookstore.service.AuthorService;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;
    private final AuthorModelAssembler assembler;

    public AuthorController(AuthorService authorService, AuthorModelAssembler assembler) {
        this.authorService = authorService;
        this.assembler = assembler;
    }

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public EntityModel<Author> getAuthorById(@PathVariable Long id) {
        Author author = authorService.findAuthorById(id);
        return assembler.toModel(author);
    }
}
