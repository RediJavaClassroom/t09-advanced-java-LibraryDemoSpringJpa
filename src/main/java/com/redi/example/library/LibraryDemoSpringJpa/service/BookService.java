package com.redi.example.library.LibraryDemoSpringJpa.service;

import com.redi.example.library.LibraryDemoSpringJpa.repository.data.BookRepository;
import com.redi.example.library.LibraryDemoSpringJpa.repository.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Long createBook(final Book book) {
        return bookRepository.save(book).getId();
    }

    public Optional<Book> getBook(final Long id) {
        return bookRepository.findById(id);
    }

    public Optional<List<Book>> getByTitle(String title) {
        return bookRepository.findByTitleIsLike(title);
    }

    public Optional<List<Book>> getByAId(Long id) {
        return bookRepository.getBookByAuthorId(id);
    }
}
