package com.patient.controller;

import com.patient.model.dto.request.AllergyRequestDTO;
import com.patient.model.dto.response.AllergyResponseDTO;
import com.patient.service.interfaces.IAllergyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients/{patientId}/allergies")
@RequiredArgsConstructor
public class AllergyController {

    private final IAllergyService allergyService;

    @PostMapping
    public ResponseEntity<AllergyResponseDTO> addAllergy(
            @PathVariable Long patientId,
            @Valid @RequestBody AllergyRequestDTO request) {
        return new ResponseEntity<>(
                allergyService.addAllergy(patientId, request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AllergyResponseDTO>> getAllergies(
            @PathVariable Long patientId) {
        return ResponseEntity.ok(allergyService.getAllergies(patientId));
    }

    @PutMapping("/{allergyId}")
    public ResponseEntity<AllergyResponseDTO> updateAllergy(
            @PathVariable Long patientId,
            @PathVariable Long allergyId,
            @Valid @RequestBody AllergyRequestDTO request) {
        return ResponseEntity.ok(
                allergyService.updateAllergy(patientId, allergyId, request));
    }

    @DeleteMapping("/{allergyId}")
    public ResponseEntity<Void> deleteAllergy(
            @PathVariable Long patientId,
            @PathVariable Long allergyId) {
        allergyService.deleteAllergy(patientId, allergyId);
        return ResponseEntity.noContent().build();
    }
}
