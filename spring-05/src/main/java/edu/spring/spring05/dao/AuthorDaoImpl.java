package edu.spring.spring05.dao;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import edu.spring.spring05.domain.Author;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AuthorDaoImpl implements AuthorDao {

    @Autowired
    private NamedParameterJdbcOperations jdbcTemplate;

    @Override
    public void add(Author author) {
        final HashMap<String, Object> params = new HashMap<>();
        params.put("name", author.getName());
        jdbcTemplate.update("insert into authors 'name' values :name", params);
    }

    @Override
    public Author findByName(String name) {
        final HashMap<String, Object> params = new HashMap<>();
        params.put("name", name);
        return jdbcTemplate.queryForObject("select * from authors where name=:name", params, Author.class);
    }

    @Override
    public Author findById(String id) {
        final HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        return jdbcTemplate.queryForObject("select * from authors where id=:id", params, Author.class);
    }

    @Override
    public void update(Author author) {
        final HashMap<String, Object> params = new HashMap<>();
        params.put("id", author.getId());
        params.put("name", author.getName());
        jdbcTemplate.update("update authors set name=:name where id=:id", params);
    }

    @Override
    public void removeById(String id) {
        final HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        jdbcTemplate.update("delete from authors where id=:id", params);
    }

    @Override
    public Integer count() {
        return jdbcTemplate.queryForObject("select count(*) from authors", new HashMap<>(), Integer.class);
    }
}
