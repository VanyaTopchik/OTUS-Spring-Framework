package edu.spring.spring05.dao;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import edu.spring.spring05.domain.Author;
import edu.spring.spring05.domain.Book;
import edu.spring.spring05.domain.Genre;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BookDaoImpl implements BookDao{

    @Autowired
    private GenreDao genreDao;

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private NamedParameterJdbcOperations jdbcTemplate;

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
        return jdbcTemplate.queryForObject("select * from books where id=:id", params, Book.class);
    }

    @Override
    public List<Book> findByAuthor(Author author) {
        final HashMap<String, Object> params = new HashMap<>();
        params.put("author_id", author.getId());
        return jdbcTemplate.queryForList("select * from books where author_id=:author_id", params, Book.class);
    }

    @Override
    public List<Book> findByGenre(Genre genre) {
        final HashMap<String, Object> params = new HashMap<>();
        params.put("genre_id", genre.getId());
        return jdbcTemplate.queryForList("select * from books where genre_id=:genre_id", params, Book.class);
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
