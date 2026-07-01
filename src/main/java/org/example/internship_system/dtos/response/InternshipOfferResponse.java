package org.example.internship_system.dtos.response;

import org.example.internship_system.entity.enums.OfferStatus;
import org.example.internship_system.entity.enums.WorkType;

import java.time.LocalDate;

public class InternshipOfferResponse {
    private Long id;
    private String title;
    private String description;
    private String requiredSkills;
    private String location;
    private WorkType type;
    private LocalDate deadline;
    private OfferStatus status;
    private Long companyId;
    private String companyName;

    public InternshipOfferResponse() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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

    public OfferStatus getStatus() { return status; }
    public void setStatus(OfferStatus status) { this.status = status; }

    public Long getCompanyId() { return companyId; }
    public void setCompanyId(Long companyId) { this.companyId = companyId; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
}