package edu.spring.spring08.service;

import edu.spring.spring08.domain.Comment;
import edu.spring.spring08.repository.BookRepository;
import edu.spring.spring08.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

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
