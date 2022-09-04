package edu.spring.spring08.service;

import edu.spring.spring08.domain.Comment;

import java.util.List;

public interface LibraryService {
    void addComment(Comment comment);

    List<Comment> getCommentsByBookId(long id);

    Comment getCommentById(long id);

    void deleteCommentById(long id);
}
