package edu.spring.spring05.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import edu.spring.spring05.domain.Author;

@Repository
@Transactional
public class AuthorDaoImpl implements AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Author author) {
        entityManager.persist(author);
    }

    @Override
    public List<Author> findByName(String name) {
        TypedQuery<Author> query = entityManager.createQuery("select a from author a where a.name=:name", Author.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public Author findById(Long id) {
        return entityManager.find(Author.class, id);
    }

    @Override
    public void update(Author author) {
        entityManager.merge(author);
    }

    @Override
    public void removeById(Long id) {
        entityManager.remove(findById(id));
    }

    @Override
    public int count() {
        TypedQuery<Integer> query = entityManager.createQuery("select count(a) from author a", Integer.class);
        return query.getSingleResult();
    }

    @Override
    public List<Author> getAllAuthors() {
        TypedQuery<Author> query = entityManager.createQuery("select a from author a", Author.class);
        return query.getResultList();
    }
}
