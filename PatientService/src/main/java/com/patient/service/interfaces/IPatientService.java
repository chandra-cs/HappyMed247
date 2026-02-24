package com.patient.service.interfaces;

import com.patient.model.dto.request.PatientRequestDTO;
import com.patient.model.dto.response.PatientResponseDTO;
import com.patient.model.entity.Patient;
import jakarta.validation.Valid;

import java.util.List;

public interface IPatientService {
    PatientResponseDTO registerPatient(PatientRequestDTO request);
    PatientResponseDTO getPatientById(Long patientId);
    List<PatientResponseDTO> getAllPatients();
    PatientResponseDTO updatePatient(Long patientId, PatientRequestDTO request);
    void deletePatient(Long patientId);
    Patient findPatientOrThrow(Long patientId);
}
