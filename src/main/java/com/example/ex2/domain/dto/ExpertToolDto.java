package com.example.ex2.domain.dto;

import com.example.ex2.domain.ExpertTool;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ExpertToolDto {
    private Long expertId;
    private Integer toolId;
    private Integer rating;


    public ExpertToolDto(ExpertTool et, Integer mark) {
        this.expertId = et.getExpert().getId();
        this.toolId = et.getTool().getId();
        this.rating = mark;
    }

    public ExpertToolDto(ExpertTool et) {
        this.expertId = et.getExpert().getId();
        this.toolId = et.getTool().getId();
        this.rating = et.getRating();
    }

    public Long getExpertId() {
        return expertId;
    }

    public void setExpertId(Long exertId) {
        expertId = exertId;
    }

    public Integer getToolId() {
        return toolId;
    }

    public void setToolId(Integer toolId) {
        this.toolId = toolId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer mark) {
        this.rating = mark;
    }
}
