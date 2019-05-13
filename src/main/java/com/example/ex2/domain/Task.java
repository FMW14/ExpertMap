package com.example.ex2.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Task {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Integer Id;

    private String name;

//    @ManyToMany
//    @JoinTable(
//            name = "task_tool",
//            joinColumns = { @JoinColumn (name = "task_id") },
//            inverseJoinColumns = { @JoinColumn(name = "tool_id") }
//    )
//    private Set<Tool> problems = new HashSet<>();

    @ManyToMany(mappedBy = "tasks")
    @JsonIgnore
    private List<Problem> problems;

    @ManyToMany
    @JsonIgnore
    private List<Tool> tools;

    public Task(String name) {
        this.name = name;
    }

    public Task() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Problem> getProblems() {
        return problems;
    }

    public void setProblems(List<Problem> problems) {
        this.problems = problems;
    }

    public List<Tool> getTools() {
        return tools;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }
}
