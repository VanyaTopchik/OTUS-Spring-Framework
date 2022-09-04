package edu.spring.spring07;

import edu.spring.spring07.domain.Author;
import edu.spring.spring07.domain.Book;
import edu.spring.spring07.domain.Genre;
import edu.spring.spring07.domain.Genres;
import edu.spring.spring07.repository.BookRepository;
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
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    public void saveAndFind_is_OK() {
        Author author = new Author("Оруэлл");
        Genre genre = new Genre(Genres.ROMAN);
        Book book = new Book(author, genre, "1984", "Моя любимая книга");
        repository.save(book);
        Assert.assertEquals(repository.findById(1L), book);
        Assert.assertEquals(repository.findAllByAuthor(author), Collections.singletonList(book));
        Assert.assertEquals(repository.findAllByGenre(genre), Collections.singletonList(book));
    }

    @Test
    public void getAll_is_OK() {
        Assert.assertEquals(repository.findAll(), Arrays.asList(new Book(new Author("Достоевский"), new Genre(Genres.ROMAN), "Преступление и наказание", "«Преступление и наказание» (1866) — роман об одном преступлении. Двойное убийство, совершенное бедным студентом из-за денег. Трудно найти фабулу проще, но интеллектуальное и душевное потрясение, которое производит роман, — неизгладимо. В чем здесь загадка? Кроме простого и очевидного ответа — «в гениальности Достоевского» — возможно, существует как минимум еще один: «проклятые» вопросы не имеют простых и положительных ответов. Нищета, собственные страдания и страдания близких всегда ставили и будут ставить человека перед выбором: имею ли я право преступить любой нравственный закон, чтобы потом стать спасителем униженных и утешителем слабых; должен ли я сперва возлюбить себя, а только потом, став сильным, возлюбить ближнего своего? Это вечные вопросы."),
                new Book(new Author("Достоевский"), new Genre(Genres.ROMAN), "Братья Карамазовы", "Самый сложный, самый многоуровневый и неоднозначный из романов Достоевского, который критики считали то «интеллектуальным детективом», то «ранним постмодернизмом», то — «лучшим из произведений о загадочной русской душе». Роман, легший в основу десятков экранизаций — от предельно точных до самых отвлеченных, — но не утративший своей духовной силы…"),
                new Book(new Author("Булгаков"), new Genre(Genres.ROMAN), "Мастер и Маргарита", "\"Мастер и Маргарита\" - итоговое произведение выдающегося отечественного прозаика и драматурга Михаила Афанасьевича Булгакова. Обещание, содержащееся на страницах книги - \"ваш роман вам принесет еще сюрпризы\", - оправдалось вполне: написанный Мастером провидческий роман о дьяволе, пожалуй, явился одной из самых загадочных, удивительных и самых читаемых книг XX столетия! Многие слова и выражения из этого произведения вошли в современный лексикон, а персонажи своею реальностью затмили действительно существующих граждан."),
                new Book(new Author("Булгаков"), new Genre(Genres.STORY), "Собачье сердце", "«Собачье сердце» – одно из самых любимых читателями произведений Михаила Булгакова. Вас ждёт полный рассказ о необыкновенном эксперименте гениального доктора."),
                new Book(new Author("Пушкин"), new Genre(Genres.ROMAN), "Евгений Онегин", "Роман в стихах «Евгений Онегин» стал центральным событием в литературной жизни пушкинской поры. И с тех пор шедевр А.С.Пушкина не утратил своей популярности, по-прежнему любим и почитаем миллионами читателей."),
                new Book(new Author("Пушкин"), new Genre(Genres.ROMAN), "Капитанская дочка", "В романе «Капитанская дочка» А.С.Пушкин нарисовал яркую картину стихийного крестьянского восстания под предводительством Емельяна Пугачева. Произведение включено в школьную программу и рекомендовано для внеклассного чтения. Для детей среднего и старшего школьного возраста."),
                new Book(new Author("Толстой"), new Genre(Genres.ROMAN), "Война и мир", "Роман-эпопея, описывающий события войн против Наполеона: 1805 года и отечественной 1812 года. Признан критикой всего мира величайшим эпическим произведением литературы нового времени."),
                new Book(new Author("Толстой"), new Genre(Genres.ROMAN), "Анна Каренина", "«Анна Каренина», один из самых знаменитых романов Льва Толстого, начинается ставшей афоризмом фразой: «Все счастливые семьи похожи друг на друга, каждая несчастливая семья несчастлива по-своему». Это книга о вечных ценностях: о любви, о вере, о семье, о человеческом достоинстве."),
                new Book(new Author("Гоголь"), new Genre(Genres.POEM), "Мертвые души", "«…Говоря о „Мертвых душах“, можно вдоволь наговориться о России», – это суждение поэта и критика П. А. Вяземского объясняет особое место поэмы Гоголя в истории русской литературы: и огромный успех у читателей, и необычайную остроту полемики вокруг главной гоголевской книги, и многообразие высказанных мнений, каждое из которых так или иначе вовлекает в размышления о природе национального мышления и культурного сознания, о настоящем и будущем России.")));
    }

    @Test
    public void removeAndCount_is_OK() {
        Assert.assertEquals(repository.count(), 10);
        repository.deleteById(1L);
        Assert.assertEquals(repository.count(), 9);
    }
}