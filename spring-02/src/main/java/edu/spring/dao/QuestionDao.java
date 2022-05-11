package edu.spring.dao;

import java.util.List;
import edu.spring.domain.Question;

public interface QuestionDao {
    List<Question> getQuestionsFromCSVFile();
}
