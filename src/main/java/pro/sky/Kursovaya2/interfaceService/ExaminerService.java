package pro.sky.Kursovaya2.interfaceService;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pro.sky.Kursovaya2.Model.Question;

import java.util.Collection;
@Service

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);

}
