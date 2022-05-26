package edu.spring.spring05.dao;

import edu.spring.spring05.domain.Genre;

public interface GenreDao {

    void save(Genre genre);
    Genre findByTitle(String title);

    Genre findById(String id);

    void update(Genre genre);

    void removeById(String id);

    Integer count();
}
