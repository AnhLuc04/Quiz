package com.example.demo.service.user_answer;

import com.example.demo.model.answer.UserAnswer;

import java.util.List;

public interface UserAnswerService {
    List<UserAnswer> findAllUserAnswer();
    UserAnswer saveUserAnswer(UserAnswer userAnswer);
    UserAnswer findUserAnswerById(Long id);
    void removeUserAnswer(Long id);
}
