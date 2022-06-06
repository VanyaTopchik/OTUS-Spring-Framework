package edu.spring.spring05.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import edu.spring.spring05.domain.Author;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AuthorDaoImpl implements AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Author author) {
        final HashMap<String, Object> params = new HashMap<>();
        params.put("name", author.getName());
        jdbcTemplate.update("insert into authors (name) values (:name)", params);
    }

    @Override
    public List<Author> findByName(String name) {
        final HashMap<String, Object> params = new HashMap<>();
        params.put("name", name);
        return jdbcTemplate.query("select * from authors where name=:name", params, new AuthorMapper());
    }

    @Override
    public Author findById(Long id) {
        return entityManager.find(Author.class, id);
        params.put("id", id);
        return jdbcTemplate.queryForObject("select * from authors where id=:id", params, new AuthorMapper());
    }

    @Override
    public void update(Author author) {
        final HashMap<String, Object> params = new HashMap<>();
        params.put("id", author.getId());
        params.put("name", author.getName());
        jdbcTemplate.update("update authors set name=:name where id=:id", params);
    }

    @Override
    public void removeById(Long id) {
        final HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        jdbcTemplate.update("update books set author_id=null where author_id=:id", params);
        jdbcTemplate.update("delete from authors where id=:id", params);
    }

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from authors", new HashMap<>(), Integer.class);
    }

    @Override
    public List<Author> getAllAuthors() {
        return jdbcTemplate.query("select * from authors", new AuthorMapper());
    }
}
