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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tool", fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonIgnore
    private List<ExpertTool> expertTools = new ArrayList<>();

    @PreRemove
    private void removeToolFromTask() {
        for (Task t : tasks) {
            t.getTools().remove(this);
        }
    }

    public Tool() {
    }

    public Tool(String name) {
        this.name = name;
    }

}
