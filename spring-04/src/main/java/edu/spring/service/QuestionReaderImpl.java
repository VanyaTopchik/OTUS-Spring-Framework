package edu.spring.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import edu.spring.domain.Question;

@Service
public class QuestionReaderImpl implements QuestionReader {

    @Value("${file.path}")
    private String filePath;

    @Override
    public ArrayList<Question> getQuestionsFromCSVFile() {
        ArrayList<Question> questions = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> list = reader.readAll();
            list.forEach(arr -> {
                if (!arr[0].startsWith("\uFEFF")) {
                    Question question = new Question(arr[0] + ":\n" + arr[1] + "\n",
                            Arrays.asList(arr[2], arr[3], arr[4], arr[5]),
                            Integer.valueOf(arr[6].trim()));
                    questions.add(question);
                }
            });
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return questions;
    }
}
