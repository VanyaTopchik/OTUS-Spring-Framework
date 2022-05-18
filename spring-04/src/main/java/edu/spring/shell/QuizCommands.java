package edu.spring.shell;

import java.io.IOException;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import edu.spring.service.QuizService;

@ShellComponent
public class QuizCommands {

    private final QuizService quizService;

    public QuizCommands(QuizService quizService) {
        this.quizService = quizService;
    }

    @ShellMethod("Start testing program")
    public void start() throws IOException {
        quizService.startTest();
    }

}
