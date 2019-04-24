package com.example.ex2.domain;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@EnableTransactionManagement
public class Expert {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    private String surname;

    private String patronymic;


//    @ManyToMany(mappedBy = "experts")
//    private List<Tool> tools;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "expert", fetch = FetchType.EAGER, orphanRemoval = true)
//    private Set<ExpertTool> expertTools;
    private List<ExpertTool> expertTools = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Expert expert = (Expert) o;
        return Objects.equals(name, expert.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Expert() {
    }

    public Expert(String name) {
        this.name = name;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public List<ExpertTool> getExpertTools() {
        return expertTools;
    }

    public void setExpertTools(List<ExpertTool> expertTools) {
        this.expertTools = expertTools;
    }

    //    public List<Tool> getTools() {
//        return tools;
//    }
//
//    public void setTools(List<Tool> tools) {
//        this.tools = tools;
//    }
}
