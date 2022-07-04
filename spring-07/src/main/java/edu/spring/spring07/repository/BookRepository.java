package edu.spring.spring07.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.spring.spring07.domain.Author;
import edu.spring.spring07.domain.Book;
import edu.spring.spring07.domain.Genre;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByAuthor(Author author);

    List<Book> findAllByGenre(Genre genre);
}
