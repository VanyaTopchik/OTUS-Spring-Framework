package edu.spring.spring08;

import edu.spring.spring08.domain.Author;
import edu.spring.spring08.repository.AuthorRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository repository;

    @Test
    public void saveAndFind_is_OK() {
        Author author = new Author("Карамзин");
        repository.save(author);
        Assert.assertEquals(repository.findById(1L).get(), author);
        Assert.assertEquals(repository.findAllByName("Карамзин"), Collections.singletonList(author));
    }

    @Test
    public void getAll_is_OK() {
        Assert.assertEquals(repository.findAll(), Arrays.asList(new Author("Достоевский"), new Author("Булгаков"), new Author("Пушкин"), new Author("Толстой"), new Author("Оруэлл")));
    }

    @Test
    public void removeAndCount_is_OK() {
        Assert.assertEquals(repository.count(), 5);
        repository.deleteById(1L);
        Assert.assertEquals(repository.count(), 4);
    }
}
