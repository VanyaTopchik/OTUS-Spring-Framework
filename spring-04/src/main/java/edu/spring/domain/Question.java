package edu.spring.domain;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question question1 = (Question) o;
        return Objects.equals(getQuestion(), question1.getQuestion()) &&
                Objects.equals(getAnswerOptions(), question1.getAnswerOptions()) &&
                Objects.equals(getRightAnswer(), question1.getRightAnswer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuestion(), getAnswerOptions(), getRightAnswer());
    }

    private final String question;
    private final List<String> answerOptions;
    private final Integer rightAnswer;
}
