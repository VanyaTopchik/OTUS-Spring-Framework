package edu.spring.spring07.dao;

import java.util.List;
import edu.spring.spring07.domain.Author;
import edu.spring.spring07.domain.Book;
import edu.spring.spring07.domain.Genre;

public interface BookDao {

    void save(Book book);

    Book findById(Long id);

    List<Book> findByAuthor(Author author);

    List<Book> findByGenre(Genre genre);

    void update(Book book);

    void removeById(Long id);

    int count();

    List<Book> getAllBooks();
}
