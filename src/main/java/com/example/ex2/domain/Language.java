package com.example.ex2.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "_lang")
public class Language {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long Id;
    @Column(name = "title_ru")
    private String titleru;

    @ManyToMany(mappedBy = "lang")

    private List<Expert> experts;

    public Language() {
    }

    public Language(String title_ru, String title_en) {
        this.titleru = title_ru;
    }

//    public Long getId() {
//        return Id;
//    }
//
//    public void setId(Long id) {
//        Id = id;
//    }
//
//    public String getTitle_ru() {
//        return titleru;
//    }
//
//    public void setTitle_ru(String title_ru) {
//        this.titleru = title_ru;
//    }
//
//    public List<Expert> getExperts() {
//        return experts;
//    }
//
//    public void setExperts(List<Expert> experts) {
//        this.experts = experts;
//    }
}
