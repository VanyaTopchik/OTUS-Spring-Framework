package edu.spring.spring05;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;
import edu.spring.spring05.dao.GenreDao;
import edu.spring.spring05.domain.Genre;
import edu.spring.spring05.domain.Genres;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LibraryApplication.class)
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class GenreDaoTest {

    @Autowired
    private GenreDao genreDao;

    @Test
    public void saveAndFind_is_OK() {
        Genre genre = new Genre(5L, Genres.COMEDY);
        genreDao.save(genre);
        Assert.assertEquals(genreDao.findById(5L), genre);
        Assert.assertEquals(genreDao.findByGenre(Genres.COMEDY), Arrays.asList(new Genre(4L, Genres.COMEDY), genre));
    }

    @Test
    public void updateAndGetAll_is_OK() {
        Assert.assertEquals(genreDao.getAllGenres(), Arrays.asList(new Genre(1L, Genres.ROMAN), new Genre(2L, Genres.STORY), new Genre(3L, Genres.POEM),new Genre(4L, Genres.COMEDY)));
        Genre genre = new Genre(4L, Genres.ROMAN);
        genreDao.update(genre);
        Assert.assertEquals(genreDao.getAllGenres(), Arrays.asList(new Genre(1L, Genres.ROMAN), new Genre(2L, Genres.STORY), new Genre(3L, Genres.POEM), genre));
    }

    @Test
    public void removeAndCount_is_OK() {
        Assert.assertEquals(genreDao.count(), 4);
        genreDao.removeById(1L);
        Assert.assertEquals(genreDao.count(), 3);
    }

}
