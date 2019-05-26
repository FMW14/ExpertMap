package com.example.ex2.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@Entity
//@EnableTransactionManagement
public class Expert {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long Id;

    @NotBlank(message = "Name cannot be empty")
    @Length(max = 255, message = "Name too long")
    private String name;

    @NotBlank(message = "Surname cannot be empty")
    @Length(max = 255, message = "Surname too long")
    private String surname;

    @Length(max = 255, message = "Patronymic too long")
    private String patronymic;

    @Email
    @Length(max = 255, message = "Email too long")
    private String email;

    @Length(max = 255, message = "Phone too long")
    private String phone;

    @Length(max = 255, message = "City name too long")
    private String city;

    private Boolean online;

    private Boolean offline;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "expert", fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonIgnore
//    private Set<ExpertTool> expertTools;
    private List<ExpertTool> expertTools = new ArrayList<>();

    @ManyToMany
    @JsonIgnore
    private List<Language> lang;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", columnDefinition = "bigint")
    @JsonIgnore
    @NotNull(message = "Select country")
    private Country country;

    public Expert() {
    }

    public Expert(String name) {
        this.name = name;
    }


}
