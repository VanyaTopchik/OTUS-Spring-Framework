package edu.spring.spring07.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import edu.spring.spring07.domain.Genre;
import edu.spring.spring07.domain.Genres;

@Repository
@Transactional
public class GenreDaoImpl implements GenreDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Genre genre) {
        entityManager.persist(genre);
    }

    @Override
    public List<Genre> findByGenre(Genres genre) {
        TypedQuery<Genre> query = entityManager.createQuery("select a from Genre a where a.genre=:genre", Genre.class);
        query.setParameter("genre", genre);
        return query.getResultList();
    }

    @Override
    public Genre findById(Long id) {
        return entityManager.find(Genre.class, id);
    }

    @Override
    public void update(Genre genre) {
        entityManager.merge(genre);
    }

    @Override
    public void removeById(Long id) {
        entityManager.remove(findById(id));
    }

    @Override
    public int count() {
        TypedQuery<Integer> query = entityManager.createQuery("select count(a) from Genre a", Integer.class);
        return query.getSingleResult();
    }

    @Override
    public List<Genre> getAllGenres() {
        TypedQuery<Genre> query = entityManager.createQuery("select a from Genre a", Genre.class);
        return query.getResultList();
    }
}