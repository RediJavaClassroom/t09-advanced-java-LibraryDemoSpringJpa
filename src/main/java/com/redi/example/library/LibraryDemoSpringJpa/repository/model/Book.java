package com.redi.example.library.LibraryDemoSpringJpa.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private Integer edition;
    private Integer year;

    private String ISBN;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Author author;
}
