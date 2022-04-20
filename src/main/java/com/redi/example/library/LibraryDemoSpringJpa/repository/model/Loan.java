package com.redi.example.library.LibraryDemoSpringJpa.repository.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "id")
    private Book book;
}
