package com.example.demo.service.user_answer;

import com.example.demo.model.answer.UserAnswer;
import com.example.demo.repository.user_answer.UserAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAnswerServiceImpl implements UserAnswerService{
    @Autowired
    UserAnswerRepository userAnswerRepository;

    @Override
    public List<UserAnswer> findAllUserAnswer() {
        return userAnswerRepository.findAll();
    }

    @Override
    public UserAnswer saveUserAnswer(UserAnswer userAnswer) {
        return userAnswerRepository.save(userAnswer);
    }

    @Override
    public UserAnswer findUserAnswerById(Long id) {
        return userAnswerRepository.findById(id).orElse(null);
    }

    @Override
    public void removeUserAnswer(Long id) {
        userAnswerRepository.deleteById(id);
    }
}
