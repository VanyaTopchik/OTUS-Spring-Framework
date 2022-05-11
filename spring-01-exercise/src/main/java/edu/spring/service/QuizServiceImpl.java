package edu.spring.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import edu.spring.dao.QuestionDao;
import edu.spring.domain.Person;
import edu.spring.domain.Question;

public class QuizServiceImpl implements QuizService{

    private final QuestionDao dao;

    private final BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

    public QuizServiceImpl(QuestionDao dao) {
        this.dao = dao;
    }

    public void startTest() throws IOException {
        List<Question> questions = dao.getQuestionsFromCSVFile();
        System.out.println("Welcome to the test for students taking a course on the basics of Linux.");

        System.out.println("What is your name?");
        String name = consoleReader.readLine();

        System.out.println("What is your surname?");
        String surname = consoleReader.readLine();

        Person person = new Person(name, surname, 0);
        System.out.println("Let's start the quiz, " + person.getName() + " " + person.getSurname());

        questions.forEach(question -> {

            System.out.println(question.getQuestion());
            System.out.println("Answer options: ");
            question.getAnswerOptions().forEach(System.out::println);
            System.out.println("\nEnter the number of the correct answer: ");
            Integer rightAnswer = question.getRightAnswer();
            Integer answer = readAnswer();
            if (rightAnswer.equals(answer)) {
                System.out.println("Right!\n");
                person.setScore(person.getScore()+1);
            } else {
                System.out.println("Wrong!\nThe correct answer is " + rightAnswer + "\n");
            }
        });
        printResult(person);
    }

    private void printResult(Person person) {
        System.out.print("Quiz done. " + person.getName() + " " + person.getSurname() + "  scored " + person.getScore());
        switch (person.getScore()){
            case 1:
                System.out.print(" point");
                break;
            case 0:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.print(" points");
                break;
        }
    }

    private Integer readAnswer() {
        Integer answer = null;
        try {
            answer = Integer.valueOf(consoleReader.readLine().trim());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error entering response number.");
        }
        return answer;
    }
}
