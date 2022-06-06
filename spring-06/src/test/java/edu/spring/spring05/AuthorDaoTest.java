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
import edu.spring.spring05.dao.AuthorDao;
import edu.spring.spring05.domain.Author;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LibraryApplication.class)
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class AuthorDaoTest {

    @Autowired
    private AuthorDao AuthorDao;

    @Test
    public void saveAndFind_is_OK() {
        Author author = new Author(6L, "Карамзин");
        AuthorDao.save(author);
        Assert.assertEquals(AuthorDao.findById(6L), author);
        Assert.assertEquals(AuthorDao.findByName("Карамзин"), Collections.singletonList(author));
    }

    @Test
    public void updateAndGetAll_is_OK() {
        Assert.assertEquals(AuthorDao.getAllAuthors(), Arrays.asList(new Author(1L, "Достоевский"), new Author(2L, "Булгаков"), new Author(3L, "Пушкин"), new Author(4L, "Толстой"), new Author(5L, "Гоголь")));
        Author author = new Author(5L, "Оруэлл");
        AuthorDao.update(author);
        Assert.assertEquals(AuthorDao.getAllAuthors(), Arrays.asList(new Author(1L, "Достоевский"), new Author(2L, "Булгаков"), new Author(3L, "Пушкин"), new Author(4L, "Толстой"), new Author(5L, "Оруэлл")));
    }

    @Test
    public void removeAndCount_is_OK() {
        Assert.assertEquals(AuthorDao.count(), 5);
        AuthorDao.removeById(1L);
        Assert.assertEquals(AuthorDao.count(), 4);
    }
}
