package com.example.ex2.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ExpertToolId implements Serializable {

    @Column(name = "expert_id", columnDefinition = "serial")
    private Long expertId;

    @Column(name = "tool_id", columnDefinition = "serial")
    private Integer toolId;

    private ExpertToolId() {}

    public ExpertToolId(
            Long expertId,
            Integer toolId) {
        this.expertId = expertId;
        this.toolId = toolId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        ExpertToolId that = (ExpertToolId) o;
        return Objects.equals(expertId, that.expertId) &&
                Objects.equals(toolId, that.toolId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expertId, toolId);
    }

//    public Integer getExpertId() {
//        return expertId;
//    }
//
//    public void setExpertId(Integer expertId) {
//        this.expertId = expertId;
//    }


    public Long getExpertId() {
        return expertId;
    }

    public void setExpertId(Long expertId) {
        this.expertId = expertId;
    }

    public Integer getToolId() {
        return toolId;
    }

    public void setToolId(Integer toolId) {
        this.toolId = toolId;
    }
}
