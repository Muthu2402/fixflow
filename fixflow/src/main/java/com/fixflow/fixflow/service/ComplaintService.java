package com.fixflow.fixflow.service;

import com.fixflow.fixflow.dto.ComplaintRequest;
import com.fixflow.fixflow.dto.ComplaintResponse;
import com.fixflow.fixflow.enums.ComplaintStatus;

import java.util.List;

public interface ComplaintService {
    // Accept DTO
    ComplaintResponse createComplaint(ComplaintRequest dto);

    List<ComplaintResponse> getAllComplaints();

    ComplaintResponse getComplaintById(Long id);

    ComplaintResponse updateStatus(Long id, ComplaintStatus status);

    ComplaintResponse assignComplaint(Long id, String technician);
}