package com.example.ex2.pojo;

import com.example.ex2.domain.ExpertTool;

import java.util.ArrayList;
import java.util.List;

public class ToolRate {
    private String toolname;
    private Integer rate;

    public ToolRate() {
    }

    public ToolRate(ExpertTool et) {
        this.toolname = et.getTool().getName();
        this.rate = et.getRating();
    }

    public ToolRate(String toolname) {
        this.toolname = toolname;
    }

    public ToolRate(String toolname, int rate) {
        this.toolname = toolname;
        this.rate = rate;
    }

    public String getToolname() {
        return toolname;
    }

    public void setToolname(String toolname) {
        this.toolname = toolname;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
