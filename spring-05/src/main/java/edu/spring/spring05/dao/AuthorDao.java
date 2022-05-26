package edu.spring.spring05.dao;

import edu.spring.spring05.domain.Author;

public interface AuthorDao {

    void add(Author author);

    Author findByName(String name);

    Author findById(String id);

    void update(Author author);

    void removeById(String id);

    Integer count();

}
