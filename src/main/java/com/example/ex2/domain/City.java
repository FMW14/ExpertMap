package com.example.ex2.domain;

import javax.persistence.*;

@Entity
@Table(name = "_cities")
public class City {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id", columnDefinition = "serial")
    private Long city_id;

//    @Lob
    private String title_ru;

    public City() {
    }

    public City(String title_ru, String title_en) {
        this.title_ru = title_ru;
    }

    public Long getId() {
        return city_id;
    }

    public void setId(Long id) {
        city_id = id;
    }

    public String getTitle_ru() {
        return title_ru;
    }

    public void setTitle_ru(String title_ru) {
        this.title_ru = title_ru;
    }

}
