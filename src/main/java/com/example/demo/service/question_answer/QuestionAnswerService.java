package com.example.demo.service.question_answer;

import com.example.demo.model.question_answer.QuestionAnswer;

import java.util.List;

public interface QuestionAnswerService {
    List<QuestionAnswer> findAllQuestionAnswer();
    QuestionAnswer findQuestionAnswerAnswerById(Long id);
    QuestionAnswer saveQuestionAnswer(QuestionAnswer questionAnswer);
    void  removeQuestionAnswer(Long id);
}
