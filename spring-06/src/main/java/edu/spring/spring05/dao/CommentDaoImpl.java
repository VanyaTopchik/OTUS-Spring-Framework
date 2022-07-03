package edu.spring.spring05.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import edu.spring.spring05.domain.Comment;

@Repository
public class CommentDaoImpl implements CommentDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void addComment(Comment comment) {
            em.persist(comment);
    }

    @Override
    public void deleteById(long id) {
        Comment comment = em.find(Comment.class, id);
        if (comment != null) {
            em.remove(comment);
        }
    }

    @Override
    public Comment getCommentById(long id) {
        return em.find(Comment.class, id);
    }
}