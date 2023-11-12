package pro.sky.Kursovaya2.Service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.Kursovaya2.Model.Question;
import pro.sky.Kursovaya2.interfaceService.ExaminerService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {
    public final JavaQuestionService testlist = new JavaQuestionService();
    JavaQuestionService javaQuestionService = Mockito.spy(JavaQuestionService.class);

    @Test
    void testAddTwoParam() {
        ////подготовка входных данных
        String question = "тест";
        String answer = "тест1";
        //подготовка ожидаемого результата
        Question expected = new Question(question, answer);
        //начало теста
        Question actual = testlist.add(question, answer);
        assertEquals(expected,actual);
    }

    @Test
    void testAdd() {
        ////подготовка входных данных
        String question = "тест";
        String answer = "тест1";
        Question test = new Question(question, answer);
        //подготовка ожидаемого результата
        Question expected = new Question(question, answer);
        //начало теста
        Question actual = testlist.add(test);
        assertEquals(expected,actual);
    }

    @Test
    void remove() {
        ////подготовка входных данных
        String question = "тест";
        String answer = "тест1";
        //подготовка ожидаемого результата
        Question expected = new Question(question, answer);
        //начало теста
        Question actual = testlist.add(question, answer);
        actual = testlist.remove(question, answer);
        assertEquals(expected,actual);
    }


    @Test
    void getAll() {
        String question = "тест1";
        String answer = "тест11";
        String question1 = "тест2";
        String answer1 = "тест22";
        String question2 = "тест3";
        String answer2 = "тест33";
        Collection<Question> expected = new HashSet<>();
        expected.add(new Question(question, answer));
        expected.add(new Question(question1, answer1));
        expected.add(new Question(question2, answer2));
            //Начало теста
        when(javaQuestionService.getAll()).thenReturn(expected);
        Collection<Question> actual = javaQuestionService.getAll();
        assertEquals(expected, actual);
    }

}