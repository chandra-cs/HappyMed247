package com.patient.service.implementation;

import com.patient.exception.AllergyNotFoundException;
import com.patient.model.dto.request.AllergyRequestDTO;
import com.patient.model.dto.response.AllergyResponseDTO;
import com.patient.model.entity.Allergy;
import com.patient.model.entity.Patient;
import com.patient.repository.IAllergyRepository;
import com.patient.service.interfaces.IAllergyService;
import com.patient.service.interfaces.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class AllergyServiceImpl implements IAllergyService {

    private final IAllergyRepository allergyRepository;
    private final IPatientService patientService;

    @Override
    public AllergyResponseDTO addAllergy(Long patientId, AllergyRequestDTO request) {
        Patient patient = patientService.findPatientOrThrow(patientId);

        Allergy allergy = new Allergy();
        allergy.setAllergyName(request.getAllergyName());
        allergy.setReaction(request.getReaction());
        allergy.setSeverity(request.getSeverity());
        allergy.setPatient(patient);

        Allergy saved = allergyRepository.save(allergy);
        return mapToResponseDTO(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AllergyResponseDTO> getAllergies(Long patientId) {
        patientService.findPatientOrThrow(patientId);
        return allergyRepository.findByPatientPatientId(patientId)
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AllergyResponseDTO updateAllergy(Long patientId, Long allergyId, AllergyRequestDTO request) {
        patientService.findPatientOrThrow(patientId);
        Allergy allergy = findAllergyOrThrow(patientId, allergyId);

        allergy.setAllergyName(request.getAllergyName());
        allergy.setReaction(request.getReaction());
        allergy.setSeverity(request.getSeverity());

        Allergy updated = allergyRepository.save(allergy);
        return mapToResponseDTO(updated);
    }

    @Override
    public void deleteAllergy(Long patientId, Long allergyId) {
        patientService.findPatientOrThrow(patientId);
        Allergy allergy = findAllergyOrThrow(patientId, allergyId);
        allergyRepository.delete(allergy);
    }

    private Allergy findAllergyOrThrow(Long patientId, Long allergyId) {
        return allergyRepository.findByAllergyIdAndPatientPatientId(allergyId, patientId)
                .orElseThrow(() -> new AllergyNotFoundException(
                        "Allergy not found with id: " + allergyId
                                + " for patient: " + patientId));
    }

    private AllergyResponseDTO mapToResponseDTO(Allergy allergy) {
        return AllergyResponseDTO.builder()
                .allergyId(allergy.getAllergyId())
                .allergyName(allergy.getAllergyName())
                .reaction(allergy.getReaction())
                .severity(allergy.getSeverity())
                .build();
    }
}
