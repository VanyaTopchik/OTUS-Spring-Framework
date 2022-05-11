package edu.spring.domain;

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

    private final String question;
    private final List<String> answerOptions;
    private final Integer rightAnswer;
}
