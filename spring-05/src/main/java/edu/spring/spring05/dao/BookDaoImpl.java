package edu.spring.spring05.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private GenreDao genreDao;

    @Autowired
    private AuthorDao authorDao;

    private final NamedParameterJdbcOperations jdbcTemplate;

    private static class BookMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            Long id = rs.getLong("id");

            Long authId = rs.getLong("author_id");
            String authorName = rs.getString("name");
            Author author = new Author(authId, authorName);

            Long genreId = rs.getLong("genre_id");
            Genres genreTitle = null;
            for (Genres genre : Genres.values()) {
                if (genre.getTitle().equals(rs.getString("genre"))) {
                    genreTitle = genre;
                }
            }
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
        authorDao.save(book.getAuthor());
        genreDao.save(book.getGenre());
        jdbcTemplate.update("insert into books (id, author_id, genre_id, title, description) values(:id, :author_id, :genre_id, :title, :description)", params);
    }

    @Override
    public Book findById(Long id) {
        final HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        return jdbcTemplate.queryForObject("select books.*, genres.genre, authors.name from books, genres, authors where books.id=:id and books.genre_id=genres.id and books.author_id=authors.id", params, new BookMapper());
    }

    @Override
    public List<Book> findByAuthor(Author author) {
        final HashMap<String, Object> params = new HashMap<>();
        params.put("author_id", author.getId());
        return jdbcTemplate.query("select books.*, genres.genre, authors.name from books, genres, authors where books.author_id=:author_id and books.genre_id=genres.id and books.author_id=authors.id", params, new BookMapper());
    }

    @Override
    public List<Book> findByGenre(Genre genre) {
        final HashMap<String, Object> params = new HashMap<>();
        params.put("genre_id", genre.getId());
        return jdbcTemplate.query("select books.*, genres.genre, authors.name from books, genres, authors where books.genre_id=:genre_id and books.genre_id=genres.id and books.author_id=authors.id", params, new BookMapper());
    }

    @Override
    public void update(Book book) {
        final HashMap<String, Object> params = new HashMap<>();
        params.put("id", book.getId());
        params.put("author_id", book.getAuthor().getId());
        params.put("genre_id", book.getGenre().getId());
        params.put("title", book.getTitle());
        params.put("description", book.getDescription());
        authorDao.update(book.getAuthor());
        genreDao.update(book.getGenre());
        jdbcTemplate.update("update books set author_id=:author_id, genre_id=:genre_id, title=:title, description=:description where id=:id", params);
    }

    @Override
    public void removeById(Long id) {
        final HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        jdbcTemplate.update("delete from books where id=:id", params);
    }

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from books", new HashMap<>(), Integer.class);
    }

    @Override
    public List<Book> getAllBooks() {
        return jdbcTemplate.query("select books.*, genres.genre, authors.name from books, genres, authors where books.genre_id=genres.id and books.author_id=authors.id", new BookMapper());
    }
}
