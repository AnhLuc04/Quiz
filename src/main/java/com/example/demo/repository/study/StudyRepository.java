package com.example.demo.repository.study;

import com.example.demo.model.study.Study;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudyRepository extends JpaRepository<Study, Long> {
    @Query("select s.id from Study s where s.user.id = :userId and s.quiz.id = :quizId")
    Long getStudyId(@Param("userId") Long userId, @Param("quizId") Long quizId);
}
