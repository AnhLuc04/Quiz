package com.example.demo.repository.assumption;

import com.example.demo.model.assumption.Assumption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssumptionRepository extends JpaRepository<Assumption, Long> {
}
