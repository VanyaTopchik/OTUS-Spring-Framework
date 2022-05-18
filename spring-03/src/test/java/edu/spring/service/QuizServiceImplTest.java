package edu.spring.service;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class QuizServiceImplTest {

    @Autowired
    QuizService quizService;

    @MockBean
    private ConsoleReader consoleReader;

    @Test
    void startTest() throws IOException {
        when(consoleReader.readLine()).thenReturn("Vanya", "Topchik", "2", "3", "1", "2", "1");
        quizService.startTest();
    }
}