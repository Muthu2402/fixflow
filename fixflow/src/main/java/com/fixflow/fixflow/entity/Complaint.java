package com.fixflow.fixflow.entity;

import com.fixflow.fixflow.enums.ComplaintStatus;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@Entity
@Table(name = "complaints")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ComplaintStatus status;

    private String assignedTechnician;

    private LocalDateTime createdAt;

    // ===== Constructors =====
    public Complaint() {
        // status will be set in Service layer
    }

    public Complaint(String name,String title, String description, ComplaintStatus status) {
        this.name = name;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    // ===== Getters & Setters =====
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ComplaintStatus getStatus() {
        return status;
    }

    public void setStatus(ComplaintStatus status) {
        this.status = status;
    }

    public String getAssignedTechnician(){
        return assignedTechnician;
    }
    public void setAssignedTechnician(String assignedTechnician){
        this.assignedTechnician = assignedTechnician;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }
    // Auto Set of Time and Date
    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
    }
}
