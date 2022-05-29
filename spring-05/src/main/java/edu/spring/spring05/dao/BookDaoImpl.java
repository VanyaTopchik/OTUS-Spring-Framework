package edu.spring.spring05.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import edu.spring.spring05.domain.Author;
import edu.spring.spring05.domain.Book;
import edu.spring.spring05.domain.Genre;
import edu.spring.spring05.domain.Genres;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BookDaoImpl implements BookDao {

    private final NamedParameterJdbcOperations jdbcTemplate;

    private static class BookMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            Long id = rs.getLong("id");

            Long authId = rs.getLong("author_id");
            String authorName = rs.getString("name");
            Author author = new Author(authId, authorName);

            Long genreId = rs.getLong("genre_id");
            Genres genreTitle = Genres.valueOf(rs.getString("title"));
            Genre genre = new Genre(genreId, genreTitle);

            String title = rs.getString("title");
            String description = rs.getString("description");

            return new Book(id, author, genre, title, description);
        }
    }

    @Override
    public void save(Book book) {
        final HashMap<String, Object> params = new HashMap<>();
        params.put("id", book.getId());
        params.put("author_id", book.getAuthor().getId());
        params.put("genre_id", book.getGenre().getId());
        params.put("title", book.getTitle());
        params.put("description", book.getDescription());
        jdbcTemplate.update("insert into books (id, author_id, genre_id, title, description) values(:id, :author_id, :genre_id, :title, :description)", params);
    }

    @Override
    public Book findById(String id) {
        final HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        return jdbcTemplate.queryForObject("select * from books where id=:id", params, new BookMapper());
    }

    @Override
    public List<Book> findByAuthor(Author author) {
        final HashMap<String, Object> params = new HashMap<>();
        params.put("author_id", author.getId());
        return jdbcTemplate.query("select * from books where author_id=:author_id", params, new BookMapper());
    }

    @Override
    public List<Book> findByGenre(Genre genre) {
        final HashMap<String, Object> params = new HashMap<>();
        params.put("genre_id", genre.getId());
        return jdbcTemplate.query("select * from books where genre_id=:genre_id", params, new BookMapper());
    }

    @Override
    public void update(Book book) {
        final HashMap<String, Object> params = new HashMap<>();
        params.put("id", book.getId());
        params.put("author_id", book.getAuthor().getId());
        params.put("genre_id", book.getGenre().getId());
        params.put("title", book.getTitle());
        params.put("description", book.getDescription());
        jdbcTemplate.update("update genres set author_id=:author_id, genre_id=:genre_id, title=:title, description=:description where id=:id", params);
    }

    @Override
    public void removeById(String id) {
        final HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        jdbcTemplate.update("delete from books where id=:id", params);
    }

    @Override
    public Integer count() {
        return jdbcTemplate.queryForObject("select count(*) from books", new HashMap<>(), Integer.class);
    }
}
