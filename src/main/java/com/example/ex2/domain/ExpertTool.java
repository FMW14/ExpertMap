package com.example.ex2.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

//@Embeddable
@Entity(name="ExpertToolEntity")
@Table(name="expert_tool")
public class ExpertTool implements Serializable {

    @EmbeddedId
    private ExpertToolId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("expertId")
    private Expert expert;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("toolId")
    private Tool tool;

//    @Basic
    @Column(name = "rating")
    private Integer rating;

    public ExpertTool(Expert expert, Tool tool) {
        this.expert = expert;
        this.tool = tool;
        this.id = new ExpertToolId(expert.getId(), tool.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        ExpertTool that = (ExpertTool) o;
        return Objects.equals(expert, that.expert) &&
                Objects.equals(tool, that.tool);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expert, tool);
    }

    public ExpertTool() {
    }

    public Expert getExpert() {
        return expert;
    }

    public void setExpert(Expert expert) {
        this.expert = expert;
    }

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
