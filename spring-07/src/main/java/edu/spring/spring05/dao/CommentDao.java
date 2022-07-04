package edu.spring.spring05.dao;

import edu.spring.spring05.domain.Comment;

public interface CommentDao {
    void addComment(Comment comment);
    void deleteById(long actualCommentId);
    Comment getCommentById(long actualCommentId);
}