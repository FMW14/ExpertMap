package com.example.ex2.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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

    @NotBlank(message = "Surname cannot be empty")
    private String patronymic;

    @Email
    private String email;

    @Length(max = 255, message = "Phone too long")
    private String phone;

    @Length(max = 255, message = "City name too long")
    private String city;

    private Boolean online;

    private Boolean offline;

//    @ManyToMany(mappedBy = "experts")
//    private List<Tool> tools;

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
    private Country country;

//    @OneToOne(fetch = FetchType.LAZY)
////    @MapsId
//    @JoinColumn(name = "city_id", columnDefinition = "bigint")
//    @JsonIgnore
//    private City city;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//
//        if (o == null || getClass() != o.getClass())
//            return false;
//
//        Expert expert = (Expert) o;
//        return Objects.equals(name, expert.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name);
//    }

    public Expert() {
    }

    public Expert(String name) {
        this.name = name;
    }

//    public Long getId() {
//        return Id;
//    }
//
//    public void setId(Long id) {
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
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public String getPatronymic() {
//        return patronymic;
//    }
//
//    public void setPatronymic(String patronymic) {
//        this.patronymic = patronymic;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public Boolean getOnline() {
//        return online;
//    }
//
//    public void setOnline(Boolean online) {
//        this.online = online;
//    }
//
//    public Boolean getOffline() {
//        return offline;
//    }
//
//    public void setOffline(Boolean offline) {
//        this.offline = offline;
//    }
//
//    public List<ExpertTool> getExpertTools() {
//        return expertTools;
//    }
//
//    public void setExpertTools(List<ExpertTool> expertTools) {
//        this.expertTools = expertTools;
//    }
//
//    public List<Language> getLang() {
//        return lang;
//    }
//
//    public void setLang(List<Language> lang) {
//        this.lang = lang;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public Country getCountry() {
//        return country;
//    }
//
//    public void setCountry(Country country) {
//        this.country = country;
//    }
//
////    public List<Tool> getTools() {
////        return tools;
////    }
////
////    public void setTools(List<Tool> tools) {
////        this.tools = tools;
////    }
}
