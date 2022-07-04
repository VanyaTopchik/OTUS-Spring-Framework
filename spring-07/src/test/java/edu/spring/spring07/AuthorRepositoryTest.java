package edu.spring.spring07;

import java.util.Arrays;
import java.util.Collections;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import edu.spring.spring07.domain.Author;
import edu.spring.spring07.repository.AuthorRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@Transactional
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository repository;
    
    @Test
    public void saveAndFind_is_OK() {
        Author author = new Author( "Карамзин");
        repository.save(author);
        Assert.assertEquals(repository.findById(1L).get(), author);
        Assert.assertEquals(repository.findAllByName("Карамзин"), Collections.singletonList(author));
    }

    @Test
    public void getAll_is_OK() {
        Assert.assertEquals(repository.findAll(),  Arrays.asList(new Author( "Достоевский"), new Author( "Булгаков"), new Author( "Пушкин"), new Author( "Толстой"), new Author( "Оруэлл")));
    }

    @Test
    public void removeAndCount_is_OK() {
        Assert.assertEquals(repository.count(), 5);
        repository.deleteById(1L);
        Assert.assertEquals(repository.count(), 4);
    }
}
