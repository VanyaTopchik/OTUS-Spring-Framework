package edu.spring;

import java.io.IOException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import edu.spring.service.QuizService;

public class Main {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        QuizService service = context.getBean(QuizService.class);
        service.startTest();
        context.close();
    }
}
