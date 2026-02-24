package com.patient.service.implementation;

import com.patient.exception.PatientNotFoundException;
import com.patient.model.dto.request.MedicalHistoryRequestDTO;
import com.patient.model.dto.response.MedicalHistoryResponseDTO;
import com.patient.model.entity.MedicalHistory;
import com.patient.model.entity.Patient;
import com.patient.repository.IMedicalHistoryRepository;
import com.patient.service.interfaces.IMedicalHistoryService;
import com.patient.service.interfaces.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class MedicalHistoryServiceImpl implements IMedicalHistoryService {

    private final IMedicalHistoryRepository medicalHistoryRepository;
    private final IPatientService patientService;

    @Override
    public MedicalHistoryResponseDTO addMedicalHistory(Long patientId, MedicalHistoryRequestDTO request) {
        Patient patient = patientService.findPatientOrThrow(patientId);

        MedicalHistory medicalHistory = new MedicalHistory();
        medicalHistory.setCondition(request.getCondition());
        medicalHistory.setNotes(request.getNotes());
        medicalHistory.setStartDate(request.getStartDate());
        medicalHistory.setEndDate(request.getEndDate());

        // Use helper method to keep bidirectional sync
        patient.addNewMedicalHistory(medicalHistory);

        MedicalHistory saved = medicalHistoryRepository.save(medicalHistory);
        return mapToResponseDTO(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MedicalHistoryResponseDTO> getMedicalHistory(Long patientId) {
        patientService.findPatientOrThrow(patientId);
        return medicalHistoryRepository.findByPatientPatientId(patientId)
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MedicalHistoryResponseDTO updateMedicalHistory(
            Long patientId, Long medicalHistoryId, MedicalHistoryRequestDTO request) {

        patientService.findPatientOrThrow(patientId);
        MedicalHistory medicalHistory = findMedicalHistoryOrThrow(patientId, medicalHistoryId);

        medicalHistory.setCondition(request.getCondition());
        medicalHistory.setNotes(request.getNotes());
        medicalHistory.setStartDate(request.getStartDate());
        medicalHistory.setEndDate(request.getEndDate());

        MedicalHistory updated = medicalHistoryRepository.save(medicalHistory);
        return mapToResponseDTO(updated);
    }

    @Override
    public void deleteMedicalHistory(Long patientId, Long medicalHistoryId) {
        Patient patient = patientService.findPatientOrThrow(patientId);
        MedicalHistory medicalHistory = findMedicalHistoryOrThrow(patientId, medicalHistoryId);
        patient.removeMedicalHistory(medicalHistory);
        medicalHistoryRepository.delete(medicalHistory);
    }

    private MedicalHistory findMedicalHistoryOrThrow(Long patientId, Long medicalHistoryId) {
        return medicalHistoryRepository.findByMedicalHistoryIdAndPatientPatientId(
                        medicalHistoryId, patientId)
                .orElseThrow(() -> new PatientNotFoundException(
                        "Medical History not found with id: " + medicalHistoryId
                                + " for patient: " + patientId));
    }

    private MedicalHistoryResponseDTO mapToResponseDTO(MedicalHistory medicalHistory) {
        return MedicalHistoryResponseDTO.builder()
                .medicalHistoryId(medicalHistory.getMedicalHistoryId())
                .condition(medicalHistory.getCondition())
                .notes(medicalHistory.getNotes())
                .startDate(medicalHistory.getStartDate())
                .endDate(medicalHistory.getEndDate())
                .build();
    }
}
