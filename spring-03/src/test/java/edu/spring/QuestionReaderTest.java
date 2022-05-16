package edu.spring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import edu.spring.domain.Question;
import edu.spring.service.QuestionReader;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class QuestionReaderTest {

    @Autowired
    QuestionReader reader;

    @Test
    public void test() {
        List<Question> result = new ArrayList<>();
        result.add(new Question("Operating system kernel is ", Arrays.asList("1. The central processor", "2. The central part of the operating system (OS) that provides applications with coordinated access to computer resources", "3. Special mode of operation with the operating system", "4. Control terminal"), 2));
        result.add(new Question("POSIX is ", Arrays.asList("1. Linux Kernel Version", "2. Linux version", "3. A set of standards describing interfaces between an operating system and an application program", "4. Windows System Call Standard"), 3));
        result.add(new Question("Who created UNIX", Arrays.asList("1. Ken Thompson and Dennis Ritchie", "2. Paul Allen and Bill Gates", "3. Steve Jobs and Steve Wozniak", "4. Linus Torvalds and Richard Stallmann"), 1));
        result.add(new Question("The author of the Linux kernel", Arrays.asList("1. Bill Gates", "2. Linus Torvalds", "3. Dennis Ritchie", "4. Richard Stallman"), 2));
        result.add(new Question("What architecture does the Linux kernel have?", Arrays.asList("1. monolithic (to be exact, monolithic-modular)", "2. microkernel", "3. topological", "4. hybrid"), 1));

        assertTrue(Arrays.equals(new List[]{reader.getQuestionsFromCSVFile()}, new List[]{result}));
    }
}
