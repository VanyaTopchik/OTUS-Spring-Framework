package edu.spring;

import java.io.IOException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import edu.spring.service.QuizService;

@Configuration
@PropertySource("classpath:main.properties")
@ComponentScan
public class Main {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        QuizService service = context.getBean(QuizService.class);
        service.startTest();
        context.close();
    }

}
