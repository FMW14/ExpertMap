package com.example.ex2.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
//@EnableTransactionManagement
public class Expert {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long Id;

    private String name;

    private String surname;

    private String patronymic;

    private String email;

    private String phone;

    private Boolean online;

    private Boolean offline;

    private String city;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public Boolean getOffline() {
        return offline;
    }

    public void setOffline(Boolean offline) {
        this.offline = offline;
    }

    public List<ExpertTool> getExpertTools() {
        return expertTools;
    }

    public void setExpertTools(List<ExpertTool> expertTools) {
        this.expertTools = expertTools;
    }

    public List<Language> getLang() {
        return lang;
    }

    public void setLang(List<Language> lang) {
        this.lang = lang;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

//    public List<Tool> getTools() {
//        return tools;
//    }
//
//    public void setTools(List<Tool> tools) {
//        this.tools = tools;
//    }
}
