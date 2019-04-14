package com.example.ex2.domain;

import javax.persistence.*;
import java.util.List;

@Entity
//@NamedQuery(name = "User.findByEmailAddress",
//        query = "select  from User u where u.emailAddress = ?1")
public class Problem {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

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
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
