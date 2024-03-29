package edu.spring.spring07.repository;

import edu.spring.spring07.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findAllByName(String name);
}
