package com.example.ex2.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@NaturalIdCache
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Tool {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Integer Id;

    @NotBlank(message = "Title cannot be empty")
    @Length(max = 255, message = "Title too long")
    private String name;

    @ManyToMany(mappedBy = "tools")
    @JsonIgnore
    private List<Task> tasks;

//    @ManyToMany
//    private List<Expert> experts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tool", fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonIgnore
//    private Set<ExpertTool> expertTools;
    private List<ExpertTool> expertTools = new ArrayList<>();

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Tool tool = (Tool) o;
//        return Objects.equals(name, tool.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name);
//    }
//
    public Tool() {
    }

    public Tool(String name) {
        this.name = name;
    }
//
//    public Integer getId() {
//        return Id;
//    }
//
//    public void setId(Integer id) {
//        Id = id;
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
//
//    public List<ExpertTool> getExpertTools() {
//        return expertTools;
//    }
//
//    public void setExpertTools(List<ExpertTool> expertTools) {
//        this.expertTools = expertTools;
//    }

//    public List<Expert> getExperts() {
//        return experts;
//    }
//
//    public void setExperts(List<Expert> experts) {
//        this.experts = experts;
//    }
}
