package com.example.demo.service.attempt;

import com.example.demo.model.attempt.Attempt;

import java.util.List;
import java.util.Optional;

public interface AttemptService {
    List<Attempt> findAllAttempts();

    Attempt saveAttempt(Attempt attempt);

    Attempt findAttemptById(Long id) throws Exception;

    void removeAttempt(Long id);
}
