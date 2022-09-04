package edu.spring.spring08.repository;

import edu.spring.spring08.domain.Author;
import edu.spring.spring08.domain.Book;
import edu.spring.spring08.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByAuthor(Author author);

    List<Book> findAllByGenre(Genre genre);
}
