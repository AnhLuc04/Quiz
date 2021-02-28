package com.example.demo.service.assumption;

import com.example.demo.model.assumption.Assumption;

import java.util.List;

public interface AssumptionService {
    List<Assumption> findAllAssumption();
    Assumption saveAssumption(Assumption assumption);
    Assumption findAssumptionById(Long id);
    void removeAssumption(Long id);
}
