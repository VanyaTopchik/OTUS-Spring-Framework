package edu.spring.spring05.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
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

            for (Genres genre : Genres.values()) {
                if (genre.getTitle().equals(rs.getString("genre"))) {
                    return new Genre(id, genre);
                }
            }

            return null;
        }
    }

    @Override
    public void save(Genre genre) {
        final HashMap<String, Object> params = new HashMap<>();
        params.put("genre", genre.getGenre().getTitle());
        System.out.println(params);
        jdbcTemplate.update("insert into genres (genre) values (:genre)", params);
    }

    @Override
    public List<Genre> findByGenre(Genres genre) {
        final HashMap<String, Object> params = new HashMap<>();
        params.put("genre", genre.getTitle());
        System.out.println(params);
        return jdbcTemplate.query("select * from genres where genre=:genre", params, new GenreMapper());
    }

    @Override
    public Genre findById(Long id) {
        final HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        System.out.println(params);
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

    @Override
    public List<Genre> getAllGenres() {
        return jdbcTemplate.query("select id, genre from genres", new GenreMapper());
    }
}