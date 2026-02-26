package com.patient.service.interfaces;

import com.patient.model.dto.request.PatientRegisterRequestDTO;
import com.patient.model.dto.request.PatientRequestDTO;
import com.patient.model.dto.response.PatientDetailsDTO;
import com.patient.model.entity.Patient;

import java.util.List;

public interface IPatientService {
    PatientDetailsDTO registerPatient(PatientRegisterRequestDTO request);
    PatientDetailsDTO getPatientById(Long patientId);
    List<PatientDetailsDTO> getAllPatients();
    PatientDetailsDTO updatePatient(Long patientId, PatientRegisterRequestDTO request);
    void deletePatient(Long patientId);
    Patient findPatientOrThrow(Long patientId);
}
