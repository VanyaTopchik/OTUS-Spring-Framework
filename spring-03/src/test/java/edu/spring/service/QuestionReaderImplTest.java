package edu.spring.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import edu.spring.domain.Question;
import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
class QuestionReaderImplTest {

    @Autowired
    QuestionReader reader;

    @Test
    void getQuestionsFromCSVFile() {
        List<Question> result = new ArrayList<>();
        result.add(new Question("Question 1:\nOperating system kernel is \n", Arrays.asList("1. The central processor", "2. The central part of the operating system (OS) that provides applications with coordinated access to computer resources", "3. Special mode of operation with the operating system", "4. Control terminal"), 2));
        result.add(new Question("Question 2:\nPOSIX is \n", Arrays.asList("1. Linux Kernel Version", "2. Linux version", "3. A set of standards describing interfaces between an operating system and an application program", "4. Windows System Call Standard"), 3));
        result.add(new Question("Question 3:\nWho created UNIX\n", Arrays.asList("1. Ken Thompson and Dennis Ritchie", "2. Paul Allen and Bill Gates", "3. Steve Jobs and Steve Wozniak", "4. Linus Torvalds and Richard Stallmann"), 1));
        result.add(new Question("Question 4:\nThe author of the Linux kernel\n", Arrays.asList("1. Bill Gates", "2. Linus Torvalds", "3. Dennis Ritchie", "4. Richard Stallman"), 2));
        result.add(new Question("Question 5:\nWhat architecture does the Linux kernel have?\n", Arrays.asList("1. monolithic (to be exact, monolithic-modular)", "2. microkernel", "3. topological", "4. hybrid"), 1));

        assertEquals(reader.getQuestionsFromCSVFile(), result);
    }
}