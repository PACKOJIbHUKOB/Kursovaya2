package pro.sky.Kursovaya2.Service;


import org.springframework.stereotype.Component;
import pro.sky.Kursovaya2.Model.Question;
import pro.sky.Kursovaya2.interfaceService.QuestionService;

import java.util.*;
@Component
public class JavaQuestionService implements QuestionService {
    final Collection<Question> questions = new HashSet<>();


    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(String question,String answer ) {
        Question questionForRemove = new Question(question, answer);
        questions.remove(questionForRemove);
        return questionForRemove;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        int randomIdx = new Random().nextInt(questions.size());
        List<Question> newlist = new ArrayList(questions);
        return newlist.get(randomIdx);
    }
}
