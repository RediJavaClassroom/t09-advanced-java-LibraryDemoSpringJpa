package com.redi.example.library.LibraryDemoSpringJpa.repository.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String emailId;
    private String number;

    @OneToMany
    List<Book> book;
}
