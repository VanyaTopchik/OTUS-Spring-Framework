package edu.spring.spring07.service;

import java.util.List;
import edu.spring.spring07.domain.Comment;

public interface CommentService {
    void addComment(Comment comment);
    List<Comment> getCommentsByBookId(long id);
    Comment getCommentById(long id);
    void deleteCommentById(long id);
}
