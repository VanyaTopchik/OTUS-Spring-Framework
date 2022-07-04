package edu.spring.spring07.dao;

import edu.spring.spring07.domain.Comment;

public interface CommentDao {
    void addComment(Comment comment);
    void deleteById(long actualCommentId);
    Comment getCommentById(long actualCommentId);
}