package edu.spring.spring05.dao;

import edu.spring.spring05.domain.Author;

public interface AuthorDao {

    Author findByName(String name);

    Author findById(String id);

    void removeById(String id);

    Integer count();

    void add(Author author);

    void update(Author author);
}
