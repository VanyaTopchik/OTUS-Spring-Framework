package edu.spring.spring07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.spring.spring07.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
