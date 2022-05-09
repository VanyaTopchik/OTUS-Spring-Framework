package edu.spring.utils;

import java.util.List;

public class Question {
    public Question(String question, List<String> answerOptions, Integer rightAnswer) {
        this.question = question;
        this.answerOptions = answerOptions;
        this.rightAnswer = rightAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswerOptions() {
        return answerOptions;
    }

    public Integer getRightAnswer() {
        return rightAnswer;
    }

    private String question;
    private List<String> answerOptions;
    private Integer rightAnswer;
}
