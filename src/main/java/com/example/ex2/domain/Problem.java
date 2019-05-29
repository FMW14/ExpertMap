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

    @NotNull(message = "You must select the type")
    private Boolean type;
    //FALSE = INTERNAL PROBLEM, TRUE = EXTERNAL PROBLEM

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

}
