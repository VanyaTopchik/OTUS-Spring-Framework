package edu.spring.spring05.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import edu.spring.spring05.domain.Author;
import edu.spring.spring05.domain.Book;
import edu.spring.spring05.domain.Genre;

@Repository
@Transactional
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Book book) {
        entityManager.persist(book);
    }

    @Override
    public Book findById(Long id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public List<Book> findByAuthor(Author author) {
        TypedQuery<Book> query = entityManager.createQuery("select a from Book a where a.author_id=:author_id", Book.class);
        query.setParameter("author_id", author.getId());
        return query.getResultList();
    }

    @Override
    public List<Book> findByGenre(Genre genre) {
        TypedQuery<Book> query = entityManager.createQuery("select a from Book a where a.genre_id=:genre_id", Book.class);
        query.setParameter("genre_id", genre.getId());
        return query.getResultList();
    }

    @Override
    public void update(Book book) {
        entityManager.merge(book.getAuthor());
        entityManager.merge(book.getGenre());
        entityManager.merge(book);
    }

    @Override
    public void removeById(Long id) {
        entityManager.remove(findById(id));
    }

    @Override
    public int count() {
        TypedQuery<Integer> query = entityManager.createQuery("select count(a) from Book a", Integer.class);
        return query.getSingleResult();
    }

    @Override
    public List<Book> getAllBooks() {
        TypedQuery<Book> query = entityManager.createQuery("select a from Book a", Book.class);
        return query.getResultList();
    }
}
