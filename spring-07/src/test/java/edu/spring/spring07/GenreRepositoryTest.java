package edu.spring.spring07;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import edu.spring.spring07.domain.Genre;
import edu.spring.spring07.domain.Genres;
import edu.spring.spring07.repository.GenreRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@Transactional
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class GenreRepositoryTest {

    @Autowired
    private GenreRepository repository;

    @Test
    public void saveAndFind_is_OK() {
        Genre genre = new Genre(Genres.COMEDY);
        repository.save(genre);
        Assert.assertEquals(repository.findById(5L), genre);
        Assert.assertEquals(repository.findByGenre(Genres.COMEDY), Arrays.asList(new Genre(Genres.COMEDY), genre));
    }

    @Test
    public void getAll_is_OK() {
        Assert.assertEquals(repository.findAll(), Arrays.asList(new Genre(Genres.ROMAN), new Genre(Genres.STORY), new Genre(Genres.POEM)));
    }

    @Test
    public void removeAndCount_is_OK() {
        Assert.assertEquals(repository.count(), 4);
        repository.deleteById(1L);
        Assert.assertEquals(repository.count(), 3);
    }

}
