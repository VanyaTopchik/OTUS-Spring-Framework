package edu.spring.spring08.repository;

import edu.spring.spring08.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findAllByName(String name);
}
