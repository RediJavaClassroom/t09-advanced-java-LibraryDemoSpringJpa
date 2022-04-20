package com.redi.example.library.LibraryDemoSpringJpa.controller;

import com.redi.example.library.LibraryDemoSpringJpa.repository.model.Book;
import com.redi.example.library.LibraryDemoSpringJpa.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("books")
public class BookController {

    final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Long> createBook(final @RequestBody Book request) {
        Long book = bookService.createBook(request);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("book/{id}")
                .buildAndExpand(book)
                .toUri();

        return ResponseEntity.created(uri).body(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(final @PathVariable Long id) {
        Optional<Book> book = bookService.getBook(id);
        return ResponseEntity.of(book);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<Book>> getBook(final @PathVariable String title) {
        Optional<List<Book>> books = bookService.getByTitle(title);
        return ResponseEntity.of(books);
    }

    @GetMapping("/a/{id}")
    public ResponseEntity<List<Book>> getBookByAuthorId(final @PathVariable Long id) {
        Optional<List<Book>> books = bookService.getByAId(id);
        return ResponseEntity.of(books);
    }
}
