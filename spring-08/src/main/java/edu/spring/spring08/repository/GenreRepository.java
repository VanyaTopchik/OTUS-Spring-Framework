package edu.spring.spring08.repository;

import edu.spring.spring08.domain.Genre;
import edu.spring.spring08.domain.Genres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findByGenre(Genres genres);
}
