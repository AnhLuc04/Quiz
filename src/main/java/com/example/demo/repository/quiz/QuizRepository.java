package com.example.demo.repository.quiz;

import com.example.demo.model.quiz.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuizRepository extends JpaRepository<Quiz,Long> {
    @Query(value = "select count(category_id) from Quiz s where s.category_id = :id", nativeQuery = true)
    Long countQuizByCategoryId(@Param("id") Long id);
}
