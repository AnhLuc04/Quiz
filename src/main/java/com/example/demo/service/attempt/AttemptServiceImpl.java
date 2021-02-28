package com.example.demo.service.attempt;
;
import com.example.demo.model.assumption.Assumption;
import com.example.demo.model.attempt.Attempt;
import com.example.demo.model.question.Question;
import com.example.demo.repository.attempt.AttemptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AttemptServiceImpl implements AttemptService {
    @Autowired
    AttemptRepository attemptRepository;

    @Override
    public List<Attempt> findAllAttempts() {
        return attemptRepository.findAll();
    }

    @Override
    public Attempt saveAttempt(Attempt attempt) {
        return attemptRepository.save(attempt);
    }

    @Override
    public Attempt findAttemptById(Long id) {
       Optional<Attempt> attempt= attemptRepository.findById(id);
       return  attempt.get();
    }

    @Override
    public void removeAttempt(Long id) {
        attemptRepository.deleteById(id);
    }



    // Check score
    public double countAverageScore(Attempt attempt) {
        Boolean[] results = attemptBooleanArrayConverter(attempt);
        double countAnswerIsTrue = Arrays.stream(results).filter(value -> value == true).count();
        double score = Math.ceil(((10.0 / results.length) * countAnswerIsTrue) * 100) / 100;
        return score;
    }

    //Check isCorrect status assumption
    public Boolean checkAnswer(Assumption assumption) {
        Boolean[] assumptionBoolean = assumptionBooleanArrayConverter(assumption);
        Boolean[] questionBoolean = questionBooleanArrayConverter(assumption.getQuestion());
        return Arrays.equals(assumptionBoolean, questionBoolean);
    }

    //Convert Assumption Result into BooleanArray
    public Boolean[] assumptionBooleanArrayConverter(Assumption assumption) {
        Boolean[] answers = new Boolean[assumption.getUserAnswers().size()];
        for (int i = 0; i < assumption.getUserAnswers().size(); i++) {
            answers[i] = assumption.getUserAnswers().get(i).getCorrectAnswer();
        }
        return  answers;
    }

    //Convert Question Result into BooleanArray
    public Boolean[] questionBooleanArrayConverter(Question question) {
        Boolean[] answers = new Boolean[question.getQuestionAnswers().size()];
        for (int i = 0; i < question.getQuestionAnswers().size(); i++) {
            answers[i] = question.getQuestionAnswers().get(i).getIsCorrect();
        }
        return  answers;
    }

    //ConvertAttemptResult into BooleanArray
    public Boolean[] attemptBooleanArrayConverter(Attempt attempt) {
        Boolean[] results = new Boolean[attempt.getAssumptions().size()];
        int resultLength = results.length;
        System.out.println(attempt.getAssumptions().size());
        for (int i = 0; i < attempt.getAssumptions().size(); i++) {
            results[i] = checkAnswer(attempt.getAssumptions().get(i));
        }
        return  results;
    }
}
