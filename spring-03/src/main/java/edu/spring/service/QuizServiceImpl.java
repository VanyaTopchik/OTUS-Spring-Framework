package edu.spring.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import edu.spring.domain.Person;
import edu.spring.domain.Question;

@Service
public class QuizServiceImpl implements QuizService {

    @Value("${app.locale}")
    private Locale locale;

    private final QuestionReader dao;

    private final BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

    public QuizServiceImpl(QuestionReader dao) {
        this.dao = dao;
    }

    @Autowired
    private MessageSource messageSource;

    public void startTest() throws IOException {
        List<Question> questions = dao.getQuestionsFromCSVFile();
        System.out.println(messageSource.getMessage("quiz.welcome", null, locale));

        System.out.println(messageSource.getMessage("quiz.name", null, locale));
        String name = consoleReader.readLine();

        System.out.println(messageSource.getMessage("quiz.surname", null, locale));
        String surname = consoleReader.readLine();

        Person person = new Person(name, surname, 0);
        System.out.println(messageSource.getMessage("quiz.start", new String[]{name, surname}, locale));

        questions.forEach(question -> {

            System.out.println(question.getQuestion());
            System.out.println(messageSource.getMessage("quiz.options", null, locale));
            question.getAnswerOptions().forEach(System.out::println);
            System.out.println(messageSource.getMessage("quiz.answer", null, locale));
            Integer rightAnswer = question.getRightAnswer();
            Integer answer = readAnswer();
            if (rightAnswer.equals(answer)) {
                System.out.println(messageSource.getMessage("quiz.right", null, locale));
                person.setScore(person.getScore() + 1);
            } else {
                System.out.println(messageSource.getMessage("quiz.wrong", new String[]{String.valueOf(rightAnswer)}, locale));
            }
        });
        printResult(person);
    }

    private void printResult(Person person) {
        switch (person.getScore()) {
            case 0:
                System.out.println(messageSource.getMessage("quiz.result.0", new String[]{person.getName(), person.getSurname(), String.valueOf(person.getScore())}, locale));
                break;
            case 1:
                System.out.println(messageSource.getMessage("quiz.result.1", new String[]{person.getName(), person.getSurname(), String.valueOf(person.getScore())}, locale));
                break;
            case 2:
                System.out.println(messageSource.getMessage("quiz.result.2", new String[]{person.getName(), person.getSurname(), String.valueOf(person.getScore())}, locale));
                break;
            case 3:
                System.out.println(messageSource.getMessage("quiz.result.3", new String[]{person.getName(), person.getSurname(), String.valueOf(person.getScore())}, locale));
                break;
            case 4:
                System.out.println(messageSource.getMessage("quiz.result.4", new String[]{person.getName(), person.getSurname(), String.valueOf(person.getScore())}, locale));
                break;
            case 5:
                System.out.println(messageSource.getMessage("quiz.result.5", new String[]{person.getName(), person.getSurname(), String.valueOf(person.getScore())}, locale));
                break;
        }
    }

    private Integer readAnswer() {
        Integer answer = null;
        try {
            answer = Integer.valueOf(consoleReader.readLine().trim());
        } catch (IOException | NumberFormatException e) {
            System.out.println(messageSource.getMessage("quiz.error", null, locale));
        }
        return answer;
    }
}
