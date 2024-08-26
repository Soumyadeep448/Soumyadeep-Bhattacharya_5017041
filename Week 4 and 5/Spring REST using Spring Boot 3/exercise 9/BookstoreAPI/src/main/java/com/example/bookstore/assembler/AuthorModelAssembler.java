package com.example.bookstore.assembler;

import com.example.bookstore.controller.AuthorController;
import com.example.bookstore.model.Author;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class AuthorModelAssembler extends RepresentationModelAssemblerSupport<Author, EntityModel<Author>> {

    public AuthorModelAssembler() {
        super(AuthorController.class, EntityModel.class);
    }

    @Override
    public EntityModel<Author> toModel(Author author) {
        return EntityModel.of(author,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AuthorController.class).getAuthorById(author.getId())).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AuthorController.class).getAuthorById(author.getId())).withRel("author"));
    }
}
