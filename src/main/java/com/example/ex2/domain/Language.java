package com.example.ex2.domain;

import javax.persistence.*;

@Entity
@Table(name = "_lang")
public class Language {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long Id;
    private String title_ru;

    public Language() {
    }

    public Language(String title_ru, String title_en) {
        this.title_ru = title_ru;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle_ru() {
        return title_ru;
    }

    public void setTitle_ru(String title_ru) {
        this.title_ru = title_ru;
    }

}
