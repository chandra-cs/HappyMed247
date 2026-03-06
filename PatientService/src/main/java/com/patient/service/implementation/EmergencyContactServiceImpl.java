package com.patient.service.implementation;

import com.patient.exception.EmergencyContactNotFoundException;
import com.patient.model.dto.request.EmergencyContactRequestDTO;
import com.patient.model.dto.response.EmergencyContactResponseDTO;
import com.patient.model.entity.EmergencyContact;
import com.patient.model.entity.Patient;
import com.patient.repository.IEmergencyContactRepository;
import com.patient.service.interfaces.IEmergencyContactService;
import com.patient.service.interfaces.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class EmergencyContactServiceImpl implements IEmergencyContactService {

    private final IEmergencyContactRepository emergencyContactRepository;
    private final IPatientService patientService;

    @Override
    public EmergencyContactResponseDTO addEmergencyContact(
            Long patientId, EmergencyContactRequestDTO request) {
        Patient patient = patientService.findPatientOrThrow(patientId);

        // Check if emergency contact already exists
        if (emergencyContactRepository.findByPatientPatientId(patientId).isPresent()) {
            throw new RuntimeException(
                    "Emergency contact already exists for patient: " + patientId
                            + ". Use PUT to update.");
        }

        EmergencyContact contact = new EmergencyContact();
        contact.setEmergencyContactName(request.getEmergencyContactName());
        contact.setEmergencyContactPhone(request.getEmergencyContactPhone());
        contact.setEmergencyContactEmail(request.getEmergencyContactEmail());
        contact.setPatient(patient);

        EmergencyContact saved = emergencyContactRepository.save(contact);
        return mapToResponseDTO(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public EmergencyContactResponseDTO getEmergencyContact(Long patientId) {
        patientService.findPatientOrThrow(patientId);
        EmergencyContact contact = findContactOrThrow(patientId);
        return mapToResponseDTO(contact);
    }

    @Override
    public EmergencyContactResponseDTO updateEmergencyContact(
            Long patientId, EmergencyContactRequestDTO request) {
        patientService.findPatientOrThrow(patientId);
        EmergencyContact contact = findContactOrThrow(patientId);

        contact.setEmergencyContactName(request.getEmergencyContactName());
        contact.setEmergencyContactPhone(request.getEmergencyContactPhone());
        contact.setEmergencyContactEmail(request.getEmergencyContactEmail());

        EmergencyContact updated = emergencyContactRepository.save(contact);
        return mapToResponseDTO(updated);
    }

    @Override
    public void deleteEmergencyContact(Long patientId) {
        patientService.findPatientOrThrow(patientId);
        EmergencyContact contact = findContactOrThrow(patientId);
        emergencyContactRepository.delete(contact);
    }

    private EmergencyContact findContactOrThrow(Long patientId) {
        return emergencyContactRepository.findByPatientPatientId(patientId)
                .orElseThrow(() -> new EmergencyContactNotFoundException(
                        "Emergency contact not found for patient: " + patientId));
    }

    private EmergencyContactResponseDTO mapToResponseDTO(EmergencyContact contact) {
        return EmergencyContactResponseDTO.builder()
                .emergencyContactId(contact.getEmergencyContactId())
                .emergencyContactName(contact.getEmergencyContactName())
                .emergencyContactPhone(contact.getEmergencyContactPhone())
                .emergencyContactEmail(contact.getEmergencyContactEmail())
                .build();
    }
}
