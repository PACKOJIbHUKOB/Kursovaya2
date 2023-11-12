package pro.sky.Kursovaya2.interfaceService;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pro.sky.Kursovaya2.Model.Question;

import java.util.Collection;

@Service

public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(String question,String answer);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
