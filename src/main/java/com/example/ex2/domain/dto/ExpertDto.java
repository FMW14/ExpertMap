package com.example.ex2.domain.dto;

import com.example.ex2.domain.Expert;
import com.example.ex2.domain.ExpertTool;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
public class ExpertDto {
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private String email;
    private String phone;
    private Boolean online;
    private Boolean offline;
    private String city;
//    private Long countryId;
    private String country;
    private List<ExpertToolDto> expertToolDtos = new ArrayList<>();

    public ExpertDto(Expert expert) {
        this.id = expert.getId();
        this.name = expert.getName();
        this.surname = expert.getSurname();
        this.patronymic = expert.getPatronymic();
        this.email = expert.getEmail();
        this.phone = expert.getPhone();
        this.online = expert.getOnline();
        this.offline = expert.getOffline();
        this.country = expert.getCountry().getTitleru();
        this.city = expert.getCity();
//        this.countryId = expert.getCountry().getId();

        List<ExpertTool> ets = expert.getExpertTools();
        for(ExpertTool et: ets){
            ExpertToolDto etd = new ExpertToolDto(et);
            this.expertToolDtos.add(etd);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<ExpertToolDto> getExpertToolDtos() {
        return expertToolDtos;
    }

    public void setExpertToolDtos(List<ExpertToolDto> expertToolDtos) {
        this.expertToolDtos = expertToolDtos;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
