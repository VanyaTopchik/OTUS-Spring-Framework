package edu.spring.spring07.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.spring.spring07.dao.BookDao;
import edu.spring.spring07.dao.CommentDao;
import edu.spring.spring07.domain.Comment;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private BookDao bookDao;

    @Override
    @Transactional
    public void addComment(Comment comment) {
        commentDao.addComment(comment);
    }

    @Override
    @Transactional
    public List<Comment> getCommentsByBookId(long id) {
        return bookDao.findById(id).getComments();
    }

    @Override
    @Transactional
    public Comment getCommentById(long id) {
        return commentDao.getCommentById(id);
    }

    @Override
    @Transactional
    public void deleteCommentById(long id) {
        commentDao.getCommentById(id);
    }
}
