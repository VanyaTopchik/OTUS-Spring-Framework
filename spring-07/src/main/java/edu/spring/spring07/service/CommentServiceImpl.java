package edu.spring.spring07.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.spring.spring07.domain.Comment;
import edu.spring.spring07.repository.BookRepository;
import edu.spring.spring07.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    @Transactional
    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    @Transactional
    public List<Comment> getCommentsByBookId(long id) {
        return bookRepository.findById(id).get().getComments();
    }

    @Override
    @Transactional
    public Comment getCommentById(long id) {
        return commentRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void deleteCommentById(long id) {
        commentRepository.deleteById(id);
    }

}
