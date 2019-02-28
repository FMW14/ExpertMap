package com.example.ex2.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProbTask {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    private Integer ProblemId;

    private Integer TaskId;

    public ProbTask() {
    }

    public ProbTask(Integer problemId, Integer taskId) {
        ProblemId = problemId;
        TaskId = taskId;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getProblemId() {
        return ProblemId;
    }

    public void setProblemId(Integer problemId) {
        ProblemId = problemId;
    }

    public Integer getTaskId() {
        return TaskId;
    }

    public void setTaskId(Integer taskId) {
        TaskId = taskId;
    }
}
