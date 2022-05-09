package edu.spring.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import edu.spring.domain.Person;

public class Quiz {

    private static Integer score;
    private static ArrayList<Question> questions;

    public static void start(Person person, BufferedReader consoleReader) {
        questions = new ArrayList<>();
        score = 0;
        System.out.println("Давайте начнем наш тест, " + person.getName());
        readCSVFile();
        questions.forEach(question -> {

            System.out.println(question.getQuestion());
            System.out.println("Варианты ответа: ");
            question.getAnswerOptions().forEach(System.out::println);
            System.out.println("\nВведите номер правильного ответа: ");
            Integer rightAnswer = question.getRightAnswer();
            Integer answer = readAnswer(consoleReader);
            if (rightAnswer.equals(answer)) {
                System.out.println("Верно!\n");
                score++;
            } else {
                System.out.println("Не верно!\nПравильный ответ:" + rightAnswer + "\n");
            }
        });
        printResult(score, person);
    }

    private static void printResult(Integer score, Person person) {
        System.out.print("Тест окончен. " + person.getName() + " набрал " + score);
        switch (score){
            case 1:
                System.out.print(" очко");
                break;
            case 2:
            case 3:
            case 4:
                System.out.print(" очка");
                break;
            case 0:
            case 5:
                System.out.print(" очков");
                break;
            default:
        }
    }

    private static Integer readAnswer(BufferedReader consoleReader) {
        Integer answer = null;
        try {
            answer = Integer.valueOf(consoleReader.readLine().trim());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Неправильно введен вариант ответа.");
        }
        return answer;
    }

    private static void readCSVFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/questions.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] arr = line.split(";");
                if (!arr[0].startsWith("\uFEFF#")) {
                    Question question = new Question(arr[0] + ":\n" + arr[1] + "\n",
                            Arrays.asList(arr[2], arr[3], arr[4], arr[5]),
                            Integer.valueOf(arr[6].trim()));
                    questions.add(question);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла");
        }
    }
}
