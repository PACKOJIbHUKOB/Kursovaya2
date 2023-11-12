package pro.sky.Kursovaya2.Service;

import org.springframework.stereotype.Component;
import pro.sky.Kursovaya2.Model.Question;
import pro.sky.Kursovaya2.exception.ExaminerServiceException;
import pro.sky.Kursovaya2.interfaceService.ExaminerService;
import pro.sky.Kursovaya2.interfaceService.QuestionService;

import java.util.Collection;
import java.util.HashSet;
@Component
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if(questionService.getAll().size()<amount){
            throw new ExaminerServiceException("Запрошено большее количество вопросов, чем хранится в сервисе");

        }
        Collection<Question> listQuestions = new HashSet<>();
        while (listQuestions.size()< amount){
            listQuestions.add(questionService.getRandomQuestion());
        }
        return listQuestions;
    }
}
