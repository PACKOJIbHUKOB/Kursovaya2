package pro.sky.Kursovaya2.Service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.Kursovaya2.Model.Question;
import pro.sky.Kursovaya2.exception.ExaminerServiceException;
import pro.sky.Kursovaya2.interfaceService.ExaminerService;
import pro.sky.Kursovaya2.interfaceService.QuestionService;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    JavaQuestionService javaQuestionService = Mockito.spy(JavaQuestionService.class);

    @InjectMocks
    private ExaminerServiceImpl examinerService;




    @Test
    void getQuestions_success() {
        String question = "Question";
        String answer = "Answer";
        String question1 = "Question1";
        String answer1 = "Answer1";
        String question2 = "Question2";
        String answer2 = "Answer2";
        Collection<Question> questions = new HashSet<>();
        javaQuestionService.questions.add(new Question(question, answer));
        javaQuestionService.questions.add(new Question(question1, answer1));
        javaQuestionService.questions.add(new Question(question2, answer2));
        //Подготовка ожидаемого результата
        Collection<Question> expectedAdd = javaQuestionService.getAll().stream()
                .sorted(Comparator.comparing(Question::toString))
                .collect(Collectors.toList());

        javaQuestionService.questions.add(new Question(question, answer));
        javaQuestionService.questions.add(new Question(question1, answer1));
        javaQuestionService.questions.add(new Question(question2, answer2));
        //Начало теста
        List<Question> actualAdd = examinerService.getQuestions(3).stream()
                .sorted(Comparator.comparing(Question::toString))
                .collect(Collectors.toList());
        assertEquals(expectedAdd, actualAdd);
    }

    @Test
    void getQuestions_ExaminerServiceException() {
        int amount =1;
        //Подготовка ожидаемого результата
        String expectedMessage = "Запрошено большее количество вопросов, чем хранится в сервисе";

        //Начало теста
        Exception exception = assertThrows(
                ExaminerServiceException.class,
                ()-> examinerService.getQuestions(1)
        );
        assertEquals(expectedMessage,exception.getMessage());

    }
}