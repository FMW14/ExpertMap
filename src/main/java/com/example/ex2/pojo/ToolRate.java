package com.example.ex2.pojo;

import com.example.ex2.domain.ExpertTool;
import com.example.ex2.domain.Tool;

import java.util.ArrayList;
import java.util.List;

public class ToolRate {
    //класс для отображения на фронте
    private String toolname;
    private Integer toolid;
    private Integer rate;

    public ToolRate() {
    }

    public ToolRate(ExpertTool et) {
        this.toolname = et.getTool().getName();
        this.rate = et.getRating();
        this.toolid = et.getTool().getId();
    }

    public ToolRate(String toolname) {
        this.toolname = toolname;
    }

    public ToolRate(String toolname, int rate) {
        this.toolname = toolname;
        this.rate = rate;
    }

    public ToolRate(Tool tool, Integer rate) {
        this.toolname = tool.getName();
        this.rate = rate;
        this.toolid = tool.getId();
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

    public Integer getToolid() {
        return toolid;
    }

    public void setToolid(Integer toolid) {
        this.toolid = toolid;
    }
}
