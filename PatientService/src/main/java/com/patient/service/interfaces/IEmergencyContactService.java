package com.patient.service.interfaces;

import com.patient.model.dto.request.EmergencyContactRequestDTO;
import com.patient.model.dto.response.EmergencyContactResponseDTO;

public interface IEmergencyContactService {
    EmergencyContactResponseDTO addEmergencyContact(Long patientId, EmergencyContactRequestDTO request);
    EmergencyContactResponseDTO getEmergencyContact(Long patientId);
    EmergencyContactResponseDTO updateEmergencyContact(Long patientId, EmergencyContactRequestDTO request);
    void deleteEmergencyContact(Long patientId);

}
