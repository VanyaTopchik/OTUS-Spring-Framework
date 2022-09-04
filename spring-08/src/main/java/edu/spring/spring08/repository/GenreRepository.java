package edu.spring.spring07.repository;

import edu.spring.spring07.domain.Genre;
import edu.spring.spring07.domain.Genres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findByGenre(Genres genres);
}
