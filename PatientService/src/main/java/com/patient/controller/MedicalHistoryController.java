package com.patient.controller;

import com.patient.model.dto.request.MedicalHistoryRequestDTO;
import com.patient.model.dto.response.MedicalHistoryResponseDTO;
import com.patient.service.interfaces.IMedicalHistoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients/{patientId}/medical-history")
@RequiredArgsConstructor
public class MedicalHistoryController {

    private final IMedicalHistoryService medicalHistoryService;

    @PostMapping
    public ResponseEntity<MedicalHistoryResponseDTO> addMedicalHistory(
            @PathVariable Long patientId,
            @Valid @RequestBody MedicalHistoryRequestDTO request) {
        return new ResponseEntity<>(
                medicalHistoryService.addMedicalHistory(patientId, request),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MedicalHistoryResponseDTO>> getMedicalHistory(
            @PathVariable Long patientId) {
        return ResponseEntity.ok(medicalHistoryService.getMedicalHistory(patientId));
    }

    @PutMapping("/{medicalHistoryId}")
    public ResponseEntity<MedicalHistoryResponseDTO> updateMedicalHistory(
            @PathVariable Long patientId,
            @PathVariable Long medicalHistoryId,
            @Valid @RequestBody MedicalHistoryRequestDTO request) {
        return ResponseEntity.ok(
                medicalHistoryService.updateMedicalHistory(patientId, medicalHistoryId, request));
    }

    @DeleteMapping("/{medicalHistoryId}")
    public ResponseEntity<Void> deleteMedicalHistory(
            @PathVariable Long patientId,
            @PathVariable Long medicalHistoryId) {
        medicalHistoryService.deleteMedicalHistory(patientId, medicalHistoryId);
        return ResponseEntity.noContent().build();
    }
}