package edu.spring.spring07.service;

import edu.spring.spring07.domain.Comment;

import java.util.List;

public interface LibraryService {
    void addComment(Comment comment);

    List<Comment> getCommentsByBookId(long id);

    Comment getCommentById(long id);

    void deleteCommentById(long id);
}
