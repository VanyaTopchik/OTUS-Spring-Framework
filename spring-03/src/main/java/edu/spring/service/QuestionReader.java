package edu.spring.service;

import java.util.List;
import edu.spring.domain.Question;

public interface QuestionReader {
    List<Question> getQuestionsFromCSVFile();
}
