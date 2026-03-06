package com.patient.service.interfaces;

import com.patient.model.dto.request.MedicalDocumentRequestDTO;
import com.patient.model.dto.response.MedicalDocumentResponseDTO;

import java.util.List;

public interface IMedicalDocumentService {
    public MedicalDocumentResponseDTO addDocument(Long patientId, MedicalDocumentRequestDTO request);
    public List<MedicalDocumentResponseDTO> getDocuments(Long patientId);
    public void deleteDocument(Long patientId, Long documentId);
}
