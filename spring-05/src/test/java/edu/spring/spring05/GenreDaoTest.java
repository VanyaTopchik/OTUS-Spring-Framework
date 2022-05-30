package edu.spring.spring05;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import edu.spring.spring05.dao.GenreDao;
import edu.spring.spring05.domain.Genre;
import edu.spring.spring05.domain.Genres;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LibraryApplication.class)
public class GenreDaoTest {

    @Autowired
    private GenreDao genreDao;

    @Test
    public void saveAndFind_is_OK() {
        System.out.println(genreDao.getAllGenres());
        Genre genre = new Genre(5L, Genres.COMEDY);
        genreDao.save(genre);
        System.out.println(genreDao.getAllGenres());
        Assert.assertEquals(genreDao.findById(5L), genre);
        Assert.assertEquals(genreDao.findByGenre(Genres.COMEDY), Arrays.asList(new Genre(4L, Genres.COMEDY), genre));
    }
}
