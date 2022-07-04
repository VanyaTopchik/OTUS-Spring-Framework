package edu.spring.spring05;

import java.util.Arrays;
import java.util.Collections;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;
import edu.spring.spring07.LibraryApplication;
import edu.spring.spring07.dao.AuthorDao;
import edu.spring.spring07.domain.Author;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LibraryApplication.class)
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class AuthorDaoTest {

    @Autowired
    private AuthorDao authorDao;

    @Test
    public void saveAndFind_is_OK() {
        Author author = new Author(6L, "Карамзин");
        authorDao.save(author);
        Assert.assertEquals(authorDao.findById(6L), author);
        Assert.assertEquals(authorDao.findByName("Карамзин"), Collections.singletonList(author));
    }

    @Test
    public void updateAndGetAll_is_OK() {
        Assert.assertEquals(authorDao.getAllAuthors(), Arrays.asList(new Author(1L, "Достоевский"), new Author(2L, "Булгаков"), new Author(3L, "Пушкин"), new Author(4L, "Толстой"), new Author(5L, "Гоголь")));
        Author author = new Author(5L, "Оруэлл");
        authorDao.update(author);
        Assert.assertEquals(authorDao.getAllAuthors(), Arrays.asList(new Author(1L, "Достоевский"), new Author(2L, "Булгаков"), new Author(3L, "Пушкин"), new Author(4L, "Толстой"), new Author(5L, "Оруэлл")));
    }

    @Test
    public void removeAndCount_is_OK() {
        Assert.assertEquals(authorDao.count(), 5);
        authorDao.removeById(1L);
        Assert.assertEquals(authorDao.count(), 4);
    }
}
