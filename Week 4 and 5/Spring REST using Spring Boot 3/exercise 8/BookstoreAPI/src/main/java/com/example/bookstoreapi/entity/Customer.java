﻿package com.example.bookstoreapi.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    @NotNull
    @Email
    private String email;

    @Version
    private int version;

    // Getters and setters
}
