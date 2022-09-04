package edu.spring.spring08.repository;

import edu.spring.spring08.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
