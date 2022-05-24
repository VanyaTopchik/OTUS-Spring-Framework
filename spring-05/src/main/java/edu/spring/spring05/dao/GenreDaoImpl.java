package edu.spring.spring05.dao;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import edu.spring.spring05.domain.Genre;

@Repository
public class GenreDaoImpl implements GenreDao{

    @Autowired
    private NamedParameterJdbcOperations jdbcTemplate;

    @Override
    public Genre findByTitle(String title) {
        final HashMap<String, Object> params = new HashMap<>();
        params.put("title", title);
        return jdbcTemplate.queryForObject("select * from genres where title=:title", params, Genre.class);
    }

    @Override
    public Genre findById(String id) {
        final HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        return jdbcTemplate.queryForObject("select * from genres where id=:id", params, Genre.class);
    }

    @Override
    public void removeById(String id) {
        final HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        jdbcTemplate.update("delete from genres where id=:id", params);
    }

    @Override
    public Integer count() {
         return jdbcTemplate.queryForObject("select count(*) from genres", new HashMap<>(), Integer.class);
    }

    @Override
    public void add(Genre genre) {

    }

    @Override
    public void update(Genre genre) {

    }

}
