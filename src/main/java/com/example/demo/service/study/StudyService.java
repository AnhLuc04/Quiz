package com.example.demo.service.study;

import com.example.demo.model.study.Study;

import java.util.List;

public interface StudyService {
    List<Study> findAllStudy();
    Study saveStudy(Study study);
    Study findStudyById(Long id);
    void removeStudy(Long id);
    Long getStudyById(Long userId, Long quizId);
}
