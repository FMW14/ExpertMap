package com.example.ex2.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "_cities")
public class City {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id", columnDefinition = "serial")
    private Long city_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", columnDefinition = "bigint")
    @JsonIgnore
    private Country country;

    @OneToOne(mappedBy = "city", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private Expert expert;

    //    @Lob
    private String title_ru;
    private String region;
    private String area;


    public City() {
    }

    public City(Country country, String title_ru, String region, String area) {
        this.country = country;
        this.title_ru = title_ru;
        this.region = region;
        this.area = area;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Expert getExpert() {
        return expert;
    }

    public void setExpert(Expert expert) {
        this.expert = expert;
    }
}
