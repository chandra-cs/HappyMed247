package com.patient.controller;

import com.patient.model.dto.request.EmergencyContactRequestDTO;
import com.patient.model.dto.response.EmergencyContactResponseDTO;
import com.patient.service.interfaces.IEmergencyContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients/{patientId}/emergency-contact")
@RequiredArgsConstructor
public class EmergencyContactController {

    private final IEmergencyContactService emergencyContactService;

    @PostMapping
    public ResponseEntity<EmergencyContactResponseDTO> addEmergencyContact(
            @PathVariable Long patientId,
            @Valid @RequestBody EmergencyContactRequestDTO request) {
        return new ResponseEntity<>(
                emergencyContactService.addEmergencyContact(patientId, request),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<EmergencyContactResponseDTO> getEmergencyContact(
            @PathVariable Long patientId) {
        return ResponseEntity.ok(emergencyContactService.getEmergencyContact(patientId));
    }

    @PutMapping
    public ResponseEntity<EmergencyContactResponseDTO> updateEmergencyContact(
            @PathVariable Long patientId,
            @Valid @RequestBody EmergencyContactRequestDTO request) {
        return ResponseEntity.ok(
                emergencyContactService.updateEmergencyContact(patientId, request));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteEmergencyContact(
            @PathVariable Long patientId) {
        emergencyContactService.deleteEmergencyContact(patientId);
        return ResponseEntity.noContent().build();
    }
}
