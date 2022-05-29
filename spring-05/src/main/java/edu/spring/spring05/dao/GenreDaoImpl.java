package edu.spring.spring05.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import edu.spring.spring05.domain.Genre;
import edu.spring.spring05.domain.Genres;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class GenreDaoImpl implements GenreDao {

    private final NamedParameterJdbcOperations jdbcTemplate;

    private static class GenreMapper implements RowMapper<Genre> {

        @Override
        public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
            Long id = rs.getLong("id");

            for (Genres genre: Genres.values()){
                if( genre.getTitle().equals(rs.getString("title"))) {
                    return new Genre(id, genre);
                }
            }

            return null;
        }
    }

    @Override
    public void save(Genre genre) {
        final HashMap<String, Object> params = new HashMap<>();
        params.put("title", genre.getGenre().getTitle());
        jdbcTemplate.update("insert into genres 'title' values :title", params);
    }

    @Override
    public Genre findByTitle(Genres title) {
        final HashMap<String, Object> params = new HashMap<>();
        params.put("title", title.getTitle());
        return jdbcTemplate.queryForObject("select * from genres where title=:title", params, new GenreMapper());
    }

    @Override
    public Genre findById(String id) {
        final HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        return jdbcTemplate.queryForObject("select * from genres where id=:id", params, new GenreMapper());
    }

    @Override
    public void update(Genre genre) {
        final HashMap<String, Object> params = new HashMap<>();
        params.put("id", genre.getId());
        params.put("title", genre.getGenre().getTitle());
        jdbcTemplate.update("update genres set title=:title where id=:id", params);
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
}