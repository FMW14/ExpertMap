package com.example.ex2.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "_countries")
public class Country {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", columnDefinition = "serial")
    private Long country_id;
    private String title_ru;
    private String title_en;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country", fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<City> cities = new ArrayList<>();

    @OneToOne(mappedBy = "country", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private Expert expert;

    public Country() {
    }

    public Country(String title_ru, String title_en, List<City> cities) {
        this.title_ru = title_ru;
        this.title_en = title_en;
        this.cities = cities;
    }

    public Country(String title_ru, String title_en) {
        this.title_ru = title_ru;
        this.title_en = title_en;
    }

    public Long getId() {
        return country_id;
    }

    public void setId(Long id) {
        country_id = id;
    }

    public String getTitle_ru() {
        return title_ru;
    }

    public void setTitle_ru(String title_ru) {
        this.title_ru = title_ru;
    }

    public String getTitle_en() {
        return title_en;
    }

    public void setTitle_en(String title_en) {
        this.title_en = title_en;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public Expert getExpert() {
        return expert;
    }

    public void setExpert(Expert expert) {
        this.expert = expert;
    }
}
