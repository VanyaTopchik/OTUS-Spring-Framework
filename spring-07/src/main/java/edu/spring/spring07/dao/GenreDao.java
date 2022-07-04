package edu.spring.spring07.dao;

import java.util.List;
import edu.spring.spring07.domain.Genre;
import edu.spring.spring07.domain.Genres;

public interface GenreDao {

    void save(Genre genre);

    List<Genre> findByGenre(Genres genre);

    Genre findById(Long id);

    void update(Genre genre);

    void removeById(Long id);

    int count();

    List<Genre> getAllGenres();
}
