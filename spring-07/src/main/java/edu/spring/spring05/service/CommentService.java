package edu.spring.spring05.service;

import java.util.List;
import edu.spring.spring05.domain.Comment;

public interface CommentService {
    void addComment(Comment comment);
    List<Comment> getCommentsByBookId(long id);
    Comment getCommentById(long id);
    void deleteCommentById(long id);
}
