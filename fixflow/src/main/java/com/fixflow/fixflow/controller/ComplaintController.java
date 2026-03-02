package com.fixflow.fixflow.controller;

import com.fixflow.fixflow.dto.ComplaintRequest;
import com.fixflow.fixflow.dto.ComplaintResponse;
import com.fixflow.fixflow.enums.ComplaintStatus;
import com.fixflow.fixflow.service.ComplaintService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/complaints")
@CrossOrigin(origins = "*") // Connect to JS

public class ComplaintController {

    private final ComplaintService service;


    public ComplaintController(ComplaintService service) {
        this.service = service;
    }

    // 1. Create Complaint (User)
    @PostMapping
    public ComplaintResponse createComplaint(@RequestBody ComplaintRequest dto) {

        return service.createComplaint(dto);
    }

    // 2.Get All Complaints (Admin)
    @GetMapping
    public List<ComplaintResponse> getAllComplaints() {
        return service.getAllComplaints();
    }

    // 3.Get Complaint by ID (Tracking)
    @GetMapping("/{id}")
    public ComplaintResponse getComplaintById(@PathVariable Long id) {
        return service.getComplaintById(id);
    }

    //4. Update Complaints By Technician
    @PutMapping("/{id}/assign")
    public ResponseEntity<ComplaintResponse> assignComplaint(
            @PathVariable Long id,
            @RequestParam String technician){
        return ResponseEntity.ok(service.assignComplaint(id,technician));
    }

    // 5.Update Complaint Status (Admin / Technician)
    @PutMapping("/{id}/status")
    public ComplaintResponse updateStatus(
            @PathVariable Long id,
            @RequestParam ComplaintStatus status) {

        return service.updateStatus(id, status);
    }
}
