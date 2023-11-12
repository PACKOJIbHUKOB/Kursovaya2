package pro.sky.Kursovaya2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Kursovaya2.interfaceService.QuestionService;
import pro.sky.Kursovaya2.Model.Question;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }


    @GetMapping(path = "/add")
    public Question add (@RequestParam String question, @RequestParam String answer){
        return questionService.add(question, answer);
    }

    @GetMapping(path = "/remove")
    public Question remove(@RequestParam String question,@RequestParam String answer) {
        return questionService.remove(question, answer);
    }

    @GetMapping
    public Collection<Question> getall(){
        return questionService.getAll();
    }


}
