package com.example.ex2.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
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

}
