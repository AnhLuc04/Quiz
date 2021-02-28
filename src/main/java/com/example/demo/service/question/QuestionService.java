package com.example.demo.service.question;

import com.example.demo.model.question.Question;

import java.util.List;

public interface QuestionService {
    List<Question> findAllQuestion();
    List<Question> findAllByCodeContaining(String code);
    List<Question> findAllByCodeContainingOrTypeContainingOrLevelContaining(String code, String type, String level);

    Question findQuestionById(Long id);
    Question saveQuestion(Question question);
    void removeQuestion(Long id);

}
