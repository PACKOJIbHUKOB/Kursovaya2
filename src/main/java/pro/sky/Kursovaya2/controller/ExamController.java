package pro.sky.Kursovaya2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pro.sky.Kursovaya2.interfaceService.ExaminerService;
import pro.sky.Kursovaya2.Model.Question;

import java.util.Collection;
@RestController
@RequestMapping(path = "/exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {

        this.examinerService = examinerService;
    }
    @GetMapping(path = "/get/{amount}")
    public Collection<Question>getQuestions(@PathVariable int amount){
        return examinerService.getQuestions(amount);
    }
}
