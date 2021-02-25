package com.example.demo.controller.quiz;

import com.example.demo.model.quiz.Quiz;
import com.example.demo.service.quiz.QuizServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("admin/quizzes")
public class QuizController {
    @Autowired
    QuizServiceImpl quizService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable allQuiz() {
        return quizService.findAllQuiz();
    }

    // Create quiz
    @PostMapping( "/create")
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        quizService.saveQuiz(quiz);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Quiz>(headers,HttpStatus.OK);
    }

    // Delete quiz
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable("id") Long id) {
        Quiz quiz = quizService.findQuizById(id);
        if (quiz == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        quizService.removeQuiz(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/count/{id}")
    public Long countQuizByCategory(@PathVariable(value = "id") Long id) {
        return quizService.countQuizByCategoryId(id);
    }
    @GetMapping("/listQuiz")
    public ResponseEntity<Iterable<Quiz>>findAllQuiz(){
        Iterable<Quiz>list =quizService.findAllQuiz();
        return new ResponseEntity<Iterable<Quiz>>(list,HttpStatus.OK);
    }
}

