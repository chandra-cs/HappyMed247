package com.patient.service.interfaces;

import com.patient.model.dto.request.AllergyRequestDTO;
import com.patient.model.dto.response.AllergyResponseDTO;

import java.util.List;

public interface IAllergyService {
    AllergyResponseDTO addAllergy(Long patientId, AllergyRequestDTO request);
    List<AllergyResponseDTO> getAllergies(Long patientId);
    AllergyResponseDTO updateAllergy(Long patientId, Long allergyId, AllergyRequestDTO request);
    void deleteAllergy(Long patientId, Long allergyId);
}
