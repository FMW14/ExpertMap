package com.example.ex2.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Problem {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    private String name;

//    @ManyToMany
//    @JoinTable(
//            name = "prob_task",
//            joinColumns = { @JoinColumn (name = "problem_id") },
//            inverseJoinColumns = { @JoinColumn(name = "task_id") }
//    )
//    private Set<problemEdit.ftl> probset = new HashSet<>();

    @ManyToMany
    private List<Task> tasks;

    public Problem() {
    }

    public Problem(String name) {
        this.name = name;
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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    //    public Set<problemEdit.ftl> getProblems() {
//        return probset;
//    }
//
//    public void setProblems(Set<problemEdit.ftl> problems) {
//        this.probset = problems;
//    }
}
