package com.fixflow.fixflow.service;

import com.fixflow.fixflow.dto.ComplaintRequest;
import com.fixflow.fixflow.dto.ComplaintResponse;
import com.fixflow.fixflow.entity.Complaint;
import com.fixflow.fixflow.enums.ComplaintStatus;
import com.fixflow.fixflow.exception.ResourceNotFoundException;
import com.fixflow.fixflow.repository.ComplaintRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository repository;

    public ComplaintServiceImpl(ComplaintRepository repository) {
        this.repository = repository;
    }

    // 1. Create Complaint
    @Override
    public ComplaintResponse createComplaint(ComplaintRequest dto) {
        System.out.println("Name from DTO : "+dto.getName());
        System.out.println("Title from DTO : "+dto.getTitle());
        Complaint complaint = new Complaint();
        complaint.setName(dto.getName());
        complaint.setTitle(dto.getTitle());
        complaint.setDescription(dto.getDescription());
        complaint.setStatus(ComplaintStatus.OPEN);
        Complaint saved = repository.save(complaint);
        return mapToResponse(saved);
    }

    // 2. Get Complaint By ID
    @Override
    public ComplaintResponse getComplaintById(Long id) {
        Complaint complaint = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Complaint not found with id: " + id));
        return mapToResponse(complaint);
    }

    // 3. Get All Complaints
    @Override
    public List<ComplaintResponse> getAllComplaints() {
        List<Complaint> complaints = repository.findAll();
        return complaints.stream().map(this::mapToResponse).toList();
    }

    // 4.Assign Technician
    @Override
    public ComplaintResponse assignComplaint(Long id, String technician) {

        Complaint complaint = repository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("ComplaintNot Found with id :"+id));

        if (complaint.getStatus() == ComplaintStatus.CLOSED) {
            throw new RuntimeException("Cannot assign technician to CLOSED complaint");
        }

        if (technician == null || technician.trim().isEmpty()) {
            throw new RuntimeException("Technician name cannot be empty");
        }

        complaint.setAssignedTechnician(technician);

        // when technician assigned complaint changed OPEN into IN_PROGRESS
        if(complaint.getStatus()== ComplaintStatus.OPEN){
            complaint.setStatus(ComplaintStatus.IN_PROGRESS);
        }

        Complaint updated = repository.save(complaint);
        return mapToResponse(updated);
    }

    // 5. Update Complaint Status
    @Override
    public ComplaintResponse updateStatus(Long id, ComplaintStatus status) {

        Complaint complaint = repository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Complaint Not Found with id : "+id));

        ComplaintStatus currentStatus = complaint.getStatus();

        // 1.CLOSED complaints cannot be modified
        if (currentStatus == ComplaintStatus.CLOSED) {
            throw new RuntimeException("Closed complaints cannot be modified");
        }

        // 2. Cannot move directly from OPEN → CLOSED
        if (currentStatus == ComplaintStatus.OPEN &&
                status == ComplaintStatus.CLOSED) {

            throw new RuntimeException("Cannot move directly from OPEN to CLOSED");
        }

        // 3.IN_PROGRESS requires technician assigned
        if (status == ComplaintStatus.IN_PROGRESS &&
                (complaint.getAssignedTechnician() == null ||
                        complaint.getAssignedTechnician().isEmpty())) {

            throw new RuntimeException("Assign technician before moving to IN_PROGRESS");
        }

        complaint.setStatus(status);

        Complaint updated = repository.save(complaint);

        return mapToResponse(updated);
    }

    // Mapping Method (Entity ----> DTO)
    private ComplaintResponse mapToResponse(Complaint complaint){
        ComplaintResponse response = new ComplaintResponse();
        response.setId(complaint.getId());
        response.setName(complaint.getName());
        response.setTitle(complaint.getTitle());
        response.setDescription(complaint.getDescription());
        response.setStatus(complaint.getStatus());
        response.setAssignedTechnician(complaint.getAssignedTechnician());
        response.setCreatedAt(complaint.getCreatedAt());

        return response;
    }
}