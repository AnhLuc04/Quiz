package com.example.demo.service.quiz;


import com.example.demo.model.quiz.Quiz;

import java.util.List;

public interface QuizService  {
    List<Quiz> findAllQuiz();
    Quiz findQuizById(Long id);
    Quiz saveQuiz(Quiz quiz);
    void removeQuiz(Long id);
    Long countQuizByCategoryId(Long id);
}
