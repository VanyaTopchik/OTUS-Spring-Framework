package edu.spring.domain;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class QuestionTest {

    private final Question question = new Question("Question 1:\nOperating system kernel is \n",
            Arrays.asList("1. The central processor", "2. The central part of the operating system (OS) "
                            + "that provides applications with coordinated access to computer resources",
                    "3. Special mode of operation with the operating system", "4. Control terminal"), 2);

    @Test
    void getQuestion() {
        assertEquals(question.getQuestion(), "Question 1:\n" +
                "Operating system kernel is \n");
    }

    @Test
    void getAnswerOptions() {
        assertEquals(question.getAnswerOptions(),Arrays.asList("1. The central processor", "2. The central part of the operating system (OS) "
                        + "that provides applications with coordinated access to computer resources",
                "3. Special mode of operation with the operating system", "4. Control terminal"));
    }

    @Test
    void getRightAnswer() {
        assertEquals(question.getRightAnswer(), 2);
    }
}