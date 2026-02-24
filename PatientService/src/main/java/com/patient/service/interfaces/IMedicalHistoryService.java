package com.patient.service.interfaces;

import com.patient.model.dto.request.MedicalHistoryRequestDTO;
import com.patient.model.dto.response.MedicalHistoryResponseDTO;
import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface IMedicalHistoryService {
    MedicalHistoryResponseDTO addMedicalHistory(Long patientId, MedicalHistoryRequestDTO request);
    List<MedicalHistoryResponseDTO> getMedicalHistory(Long patientId);
    MedicalHistoryResponseDTO updateMedicalHistory(Long patientId, Long medicalHistoryId, MedicalHistoryRequestDTO request);
    void deleteMedicalHistory(Long patientId, Long medicalHistoryId);
}
