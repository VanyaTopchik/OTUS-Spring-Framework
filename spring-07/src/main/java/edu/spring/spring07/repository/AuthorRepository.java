package edu.spring.spring07.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.spring.spring07.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findAllByName(String name);

}
