package edu.spring.spring05.dao;

import java.util.List;
import edu.spring.spring05.domain.Genre;
import edu.spring.spring05.domain.Genres;

public interface GenreDao {

    void save(Genre genre);

    List<Genre> findByGenre(Genres genre);

    Genre findById(Long id);

    void update(Genre genre);

    void removeById(String id);

    Integer count();

    List<Genre> getAllGenres();
}
