package edu.spring.spring05;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import edu.spring.spring05.dao.GenreDao;
import edu.spring.spring05.domain.Genre;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LibraryApplication.class)
public class GenreDaoTest {

    @Autowired
    private GenreDao genreDao;

    @Test
    public void addGenreToDB_is_OK() {
        System.out.println(genreDao.findById("1"));
        System.out.println(genreDao.count());
        System.out.println(genreDao.findByTitle("Roman"));
        Genre genre = genreDao.findById("1");
        genre.setTitle("Tale");
        genreDao.update(genre);
    }
}
