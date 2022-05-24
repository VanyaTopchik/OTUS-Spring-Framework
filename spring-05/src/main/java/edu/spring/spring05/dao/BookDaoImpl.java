package edu.spring.spring05.dao;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import edu.spring.spring05.domain.Author;
import edu.spring.spring05.domain.Book;
import edu.spring.spring05.domain.Genre;

@Repository
public class BookDaoImpl implements BookDao{

    @Autowired
    private GenreDao genreDao;

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private NamedParameterJdbcOperations jdbcTemplate;

    @Override
    public List<Book> findByAuthor(Author author) {
        return null;
    }

    @Override
    public List<Book> findByGenre(Genre genre) {
        return null;
    }

    @Override
    public void add(Book book) {

    }

    @Override
    public void removeById(String id) {

    }

    @Override
    public void update(Book book) {

    }

    @Override
    public Book findById(String id) {
        return null;
    }

    @Override
    public Integer count() {
        return jdbcTemplate.queryForObject("select count(*) from books", new HashMap<>(), Integer.class);
    }
}
