package edu.spring.spring05.dao;


import java.util.List;
import edu.spring.spring05.domain.Author;
import edu.spring.spring05.domain.Book;
import edu.spring.spring05.domain.Genre;

public interface BookDao {
    List<Book> findByAuthor(Author author);

    List<Book> findByGenre(Genre genre);

    void add(Book book);

    void removeById(String id);

    void update(Book book);

    Book findById(String id);

    Integer count();
}
