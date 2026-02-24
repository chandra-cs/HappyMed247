package com.patient.controller;

import com.patient.model.dto.request.VisitRequestDTO;
import com.patient.model.dto.response.VisitResponseDTO;
import com.patient.service.interfaces.IVisitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients/{patientId}/visits")
@RequiredArgsConstructor
public class VisitController {

    private final IVisitService visitService;

    @PostMapping
    public ResponseEntity<VisitResponseDTO> addVisit(
            @PathVariable Long patientId,
            @Valid @RequestBody VisitRequestDTO request) {
        return new ResponseEntity<>(
                visitService.addVisit(patientId, request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VisitResponseDTO>> getVisits(
            @PathVariable Long patientId) {
        return ResponseEntity.ok(visitService.getVisits(patientId));
    }

    @PutMapping("/{visitId}")
    public ResponseEntity<VisitResponseDTO> updateVisit(
            @PathVariable Long patientId,
            @PathVariable Long visitId,
            @Valid @RequestBody VisitRequestDTO request) {
        return ResponseEntity.ok(
                visitService.updateVisit(patientId, visitId, request));
    }

    @DeleteMapping("/{visitId}")
    public ResponseEntity<Void> deleteVisit(
            @PathVariable Long patientId,
            @PathVariable Long visitId) {
        visitService.deleteVisit(patientId, visitId);
        return ResponseEntity.noContent().build();
    }
}