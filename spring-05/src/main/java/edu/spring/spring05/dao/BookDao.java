package edu.spring.spring05.dao;


import java.util.List;
import edu.spring.spring05.domain.Author;
import edu.spring.spring05.domain.Book;
import edu.spring.spring05.domain.Genre;

public interface BookDao {

    void save(Book book);

    Book findById(String id);
    List<Book> findByAuthor(Author author);

    List<Book> findByGenre(Genre genre);

    void update(Book book);

    void removeById(String id);

    Integer count();
}
