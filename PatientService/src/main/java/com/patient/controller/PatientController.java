package com.patient.controller;

import com.patient.model.dto.request.PatientRequestDTO;
import com.patient.model.dto.response.PatientResponseDTO;
import com.patient.service.interfaces.IPatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final IPatientService patientService;

    @PostMapping
    public ResponseEntity<PatientResponseDTO> registerPatient(
            @Valid @RequestBody PatientRequestDTO request) {
        return new ResponseEntity<>(patientService.registerPatient(request), HttpStatus.CREATED);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<PatientResponseDTO> getPatientById(
            @PathVariable Long patientId) {
        return ResponseEntity.ok(patientService.getPatientById(patientId));
    }

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @PutMapping("/{patientId}")
    public ResponseEntity<PatientResponseDTO> updatePatient(
            @PathVariable Long patientId,
            @Valid @RequestBody PatientRequestDTO request) {
        return ResponseEntity.ok(patientService.updatePatient(patientId, request));
    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long patientId) {
        patientService.deletePatient(patientId);
        return ResponseEntity.noContent().build();
    }
}