package com.example.demo.repository.question;
import com.example.demo.model.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAllByCodeContainingOrTypeContainingOrLevelContaining(String code, String type, String level);
    List<Question> findAllByCodeContaining(String code);
}
