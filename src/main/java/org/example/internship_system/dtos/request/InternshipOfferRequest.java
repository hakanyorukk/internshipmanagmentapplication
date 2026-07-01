package org.example.internship_system.dtos.request;

import org.example.internship_system.entity.enums.WorkType;

import java.time.LocalDate;

public class InternshipOfferRequest {
    private String title;
    private String description;
    private String requiredSkills;
    private String location;
    private WorkType type;
    private LocalDate deadline;
    private Long companyId;

    public InternshipOfferRequest() {
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getRequiredSkills() { return requiredSkills; }
    public void setRequiredSkills(String requiredSkills) { this.requiredSkills = requiredSkills; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public WorkType getType() { return type; }
    public void setType(WorkType type) { this.type = type; }

    public LocalDate getDeadline() { return deadline; }
    public void setDeadline(LocalDate deadline) { this.deadline = deadline; }

    public Long getCompanyId() { return companyId; }
    public void setCompanyId(Long companyId) { this.companyId = companyId; }
}