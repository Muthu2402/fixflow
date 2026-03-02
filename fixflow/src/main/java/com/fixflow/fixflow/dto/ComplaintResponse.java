package com.fixflow.fixflow.dto;

import com.fixflow.fixflow.enums.ComplaintStatus;

import java.time.LocalDateTime;

public class ComplaintResponse {

    private Long id;
    private String title;
    private String name;
    private String description;
    private ComplaintStatus status;
    private String assignedTechnician;
    private LocalDateTime createdAt;

    public ComplaintResponse(){

    }
    public ComplaintResponse(Long id,String name,String title,String description,ComplaintStatus status,
                             String assignedTechnician, LocalDateTime createdAt){
        this.id = id;
        this.name = name;
        this.title = title;
        this.description = description;
        this.status = status;
        this.assignedTechnician = assignedTechnician;
        this.createdAt = createdAt;
    }

    public long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public ComplaintStatus getStatus(){
        return status;
    }
    public void setStatus(ComplaintStatus status){
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


}
