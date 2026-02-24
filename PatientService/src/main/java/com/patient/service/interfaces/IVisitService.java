package com.patient.service.interfaces;

import java.util.List;

import com.patient.model.dto.request.VisitRequestDTO;
import com.patient.model.dto.response.VisitResponseDTO;

public interface IVisitService {
    VisitResponseDTO addVisit(Long patientId, VisitRequestDTO request);
    List<VisitResponseDTO> getVisits(Long patientId);
    VisitResponseDTO updateVisit(Long patientId, Long visitId, VisitRequestDTO request);
    void deleteVisit(Long patientId, Long visitId);
}
