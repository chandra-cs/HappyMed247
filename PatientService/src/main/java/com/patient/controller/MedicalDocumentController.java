package com.patient.controller;

import com.patient.model.dto.request.MedicalDocumentRequestDTO;
import com.patient.model.dto.response.MedicalDocumentResponseDTO;
import com.patient.service.interfaces.IMedicalDocumentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients/{patientId}/documents")
@RequiredArgsConstructor
public class MedicalDocumentController {

    private final IMedicalDocumentService medicalDocumentService;

    @PostMapping
    public ResponseEntity<MedicalDocumentResponseDTO> addDocument(
            @PathVariable Long patientId,
            @Valid @RequestBody MedicalDocumentRequestDTO request) {
        return new ResponseEntity<>(
                medicalDocumentService.addDocument(patientId, request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MedicalDocumentResponseDTO>> getDocuments(
            @PathVariable Long patientId) {
        return ResponseEntity.ok(medicalDocumentService.getDocuments(patientId));
    }

    @DeleteMapping("/{documentId}")
    public ResponseEntity<Void> deleteDocument(
            @PathVariable Long patientId,
            @PathVariable Long documentId) {
        medicalDocumentService.deleteDocument(patientId, documentId);
        return ResponseEntity.noContent().build();
    }
}
