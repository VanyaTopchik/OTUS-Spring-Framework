package edu.spring.spring07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.spring.spring07.domain.Genre;
import edu.spring.spring07.domain.Genres;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    Genre findByGenre(Genres genres);

}
