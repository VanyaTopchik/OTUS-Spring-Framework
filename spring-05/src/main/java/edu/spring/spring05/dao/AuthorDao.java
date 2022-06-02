package edu.spring.spring05.dao;

import java.util.List;
import edu.spring.spring05.domain.Author;

public interface AuthorDao {

    void save(Author author);

    List<Author> findByName(String name);

    Author findById(Long id);

    void update(Author author);

    void removeById(Long id);

    int count();

    List<Author> getAllAuthors();
}
