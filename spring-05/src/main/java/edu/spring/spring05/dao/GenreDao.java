package edu.spring.spring05.dao;

import edu.spring.spring05.domain.Genre;

public interface GenreDao {

    Genre findByTitle(String title);

    Genre findById(String id);

    void removeById(String id);

    Integer count();

    void add(Genre genre);

    void update(Genre genre);
}
