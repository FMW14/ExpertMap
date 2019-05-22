package com.example.ex2.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
public class Problem {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Integer id;

    @NotBlank(message = "Title cannot be empty")
    @Length(max = 255, message = "Title too long")
    private String name;

//    @NotNull(message = "Type cannot be empty")
    private Boolean type;

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

    public Problem(String name, Boolean type) {
        this.name = name;
        this.type = type;
    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<Task> getTasks() {
//        return tasks;
//    }
//
//    public void setTasks(List<Task> tasks) {
//        this.tasks = tasks;
//    }
//
//    public Boolean getType() {
//        return type;
//    }
//
//    public void setType(Boolean type) {
//        this.type = type;
//    }

    //    public Set<problemEdit.ftl> getProblems() {
//        return probset;
//    }
//
//    public void setProblems(Set<problemEdit.ftl> problems) {
//        this.probset = problems;
//    }
}
