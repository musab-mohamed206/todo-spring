package com.test.todo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProjectTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotBlank(message = "Summary cannot be blank")
    private String summary;
    private String acceptanceCriteria;
    private String status;

    public String getSummary() {
        return summary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAcceptanceCriteria() {
        return acceptanceCriteria;
    }

    public void setAcceptanceCriteria(String acceptanceCriteria) {
        this.acceptanceCriteria = acceptanceCriteria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public ProjectTask(Long id, String summary, String acceptanceCriteria, String status) {
        this.id = id;
        this.summary = summary;
        this.acceptanceCriteria = acceptanceCriteria;
        this.status = status;
    }
    
}
