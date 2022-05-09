package edu.spring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import edu.spring.domain.Person;
import edu.spring.service.PersonService;
import edu.spring.utils.Quiz;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        PersonService service = (PersonService) context.getBean("personService");

        System.out.println("Добро пожаловать на тест для студентов, проходящих курс по основам Linux.");

        System.out.println("Как тебя зовут?");
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            String name = consoleReader.readLine();
            Person person = service.getByName(name);
            Quiz.start(person, consoleReader);
        } catch (IOException e) {
            System.out.println("Неверное имя.");
        }

        context.close();
    }
}
