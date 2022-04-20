package com.redi.example.library.LibraryDemoSpringJpa.repository.data;

import com.redi.example.library.LibraryDemoSpringJpa.repository.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    Optional<List<Book>> findByTitle(String title);
    List<Book> findByTitleAndYear(String title, Integer year);
    Optional<List<Book>> findByTitleIsLike(String title);

    @Query(value = "select * from book where author_id=?1", nativeQuery = true)
    Optional<List<Book>> getBookByAuthorId(Long id);
}
