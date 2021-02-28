package com.example.demo.repository.user_answer;

import com.example.demo.model.answer.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAnswerRepository extends JpaRepository<UserAnswer, Long> {
}
