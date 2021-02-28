package com.example.demo.model.attempt;


import com.example.demo.model.assumption.Assumption;
import com.example.demo.model.study.Study;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "attempt")
@Data
public class Attempt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private String username;
    private String email;
    private double averageScore;
    private LocalDate submittedAt;
    private LocalDate createdAt;
    private Long takingTime;

    public Attempt() {
    }

    public Attempt(Long id, String status, String username, String email, double averageScore, LocalDate submittedAt, LocalDate createdAt, Long takingTime) {
        this.id = id;
        this.status = status;
        this.username = username;
        this.email = email;
        this.averageScore = averageScore;
        this.submittedAt = submittedAt;
        this.createdAt = createdAt;
        this.takingTime = takingTime;
        this.study = study;
        this.assumptions = assumptions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public LocalDate getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDate submittedAt) {
        this.submittedAt = submittedAt;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Long getTakingTime() {
        return takingTime;
    }

    public void setTakingTime(Long takingTime) {
        this.takingTime = takingTime;
    }

    public Study getStudy() {
        return study;
    }

    public void setStudy(Study study) {
        this.study = study;
    }

    public List<Assumption> getAssumptions() {
        return assumptions;
    }

    public void setAssumptions(List<Assumption> assumptions) {
        this.assumptions = assumptions;
    }

    @ManyToOne
    @JoinColumn(name = "study_id")
    @JsonIgnore
    private Study study;


    @OneToMany(mappedBy = "attempt")
    private List<Assumption> assumptions;

}
