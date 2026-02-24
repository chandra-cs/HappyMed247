package com.patient.controller;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    // ==================== PATIENT CRUD ====================

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

    // ==================== MEDICAL HISTORY ====================

    @PostMapping("/{patientId}/medical-history")
    public ResponseEntity<MedicalHistoryResponseDTO> addMedicalHistory(
            @PathVariable Long patientId,
            @Valid @RequestBody MedicalHistoryRequestDTO request) {
        return new ResponseEntity<>(
                patientService.addMedicalHistory(patientId, request), HttpStatus.CREATED);
    }

    @GetMapping("/{patientId}/medical-history")
    public ResponseEntity<List<MedicalHistoryResponseDTO>> getMedicalHistory(
            @PathVariable Long patientId) {
        return ResponseEntity.ok(patientService.getMedicalHistory(patientId));
    }

    @PutMapping("/{patientId}/medical-history/{medicalHistoryId}")
    public ResponseEntity<MedicalHistoryResponseDTO> updateMedicalHistory(
            @PathVariable Long patientId,
            @PathVariable Long medicalHistoryId,
            @Valid @RequestBody MedicalHistoryRequestDTO request) {
        return ResponseEntity.ok(
                patientService.updateMedicalHistory(patientId, medicalHistoryId, request));
    }

    @DeleteMapping("/{patientId}/medical-history/{medicalHistoryId}")
    public ResponseEntity<Void> deleteMedicalHistory(
            @PathVariable Long patientId,
            @PathVariable Long medicalHistoryId) {
        patientService.deleteMedicalHistory(patientId, medicalHistoryId);
        return ResponseEntity.noContent().build();
    }

    // ==================== ALLERGIES ====================

    @PostMapping("/{patientId}/allergies")
    public ResponseEntity<AllergyResponseDTO> addAllergy(
            @PathVariable Long patientId,
            @Valid @RequestBody AllergyRequestDTO request) {
        return new ResponseEntity<>(
                patientService.addAllergy(patientId, request), HttpStatus.CREATED);
    }

    @GetMapping("/{patientId}/allergies")
    public ResponseEntity<List<AllergyResponseDTO>> getAllergies(
            @PathVariable Long patientId) {
        return ResponseEntity.ok(patientService.getAllergies(patientId));
    }

    @PutMapping("/{patientId}/allergies/{allergyId}")
    public ResponseEntity<AllergyResponseDTO> updateAllergy(
            @PathVariable Long patientId,
            @PathVariable Long allergyId,
            @Valid @RequestBody AllergyRequestDTO request) {
        return ResponseEntity.ok(
                patientService.updateAllergy(patientId, allergyId, request));
    }

    @DeleteMapping("/{patientId}/allergies/{allergyId}")
    public ResponseEntity<Void> deleteAllergy(
            @PathVariable Long patientId,
            @PathVariable Long allergyId) {
        patientService.deleteAllergy(patientId, allergyId);
        return ResponseEntity.noContent().build();
    }

    // ==================== VISITS ====================

    @PostMapping("/{patientId}/visits")
    public ResponseEntity<VisitResponseDTO> addVisit(
            @PathVariable Long patientId,
            @Valid @RequestBody VisitRequestDTO request) {
        return new ResponseEntity<>(
                patientService.addVisit(patientId, request), HttpStatus.CREATED);
    }

    @GetMapping("/{patientId}/visits")
    public ResponseEntity<List<VisitResponseDTO>> getVisits(
            @PathVariable Long patientId) {
        return ResponseEntity.ok(patientService.getVisits(patientId));
    }

    @PutMapping("/{patientId}/visits/{visitId}")
    public ResponseEntity<VisitResponseDTO> updateVisit(
            @PathVariable Long patientId,
            @PathVariable Long visitId,
            @Valid @RequestBody VisitRequestDTO request) {
        return ResponseEntity.ok(
                patientService.updateVisit(patientId, visitId, request));
    }

    @DeleteMapping("/{patientId}/visits/{visitId}")
    public ResponseEntity<Void> deleteVisit(
            @PathVariable Long patientId,
            @PathVariable Long visitId) {
        patientService.deleteVisit(patientId, visitId);
        return ResponseEntity.noContent().build();
    }

    // ==================== MEDICAL DOCUMENTS ====================

    @PostMapping("/{patientId}/documents")
    public ResponseEntity<MedicalDocumentResponseDTO> addDocument(
            @PathVariable Long patientId,
            @Valid @RequestBody MedicalDocumentRequestDTO request) {
        return new ResponseEntity<>(
                patientService.addDocument(patientId, request), HttpStatus.CREATED);
    }

    @GetMapping("/{patientId}/documents")
    public ResponseEntity<List<MedicalDocumentResponseDTO>> getDocuments(
            @PathVariable Long patientId) {
        return ResponseEntity.ok(patientService.getDocuments(patientId));
    }

    @DeleteMapping("/{patientId}/documents/{documentId}")
    public ResponseEntity<Void> deleteDocument(
            @PathVariable Long patientId,
            @PathVariable Long documentId) {
        patientService.deleteDocument(patientId, documentId);
        return ResponseEntity.noContent().build();
    }

    // ==================== CONSENT ====================

    @PostMapping("/{patientId}/consents")
    public ResponseEntity<ConsentResponseDTO> addConsent(
            @PathVariable Long patientId,
            @Valid @RequestBody ConsentRequestDTO request) {
        return new ResponseEntity<>(
                patientService.addConsent(patientId, request), HttpStatus.CREATED);
    }

    @GetMapping("/{patientId}/consents")
    public ResponseEntity<List<ConsentResponseDTO>> getConsents(
            @PathVariable Long patientId) {
        return ResponseEntity.ok(patientService.getConsents(patientId));
    }

    @PutMapping("/{patientId}/consents/{consentId}")
    public ResponseEntity<ConsentResponseDTO> updateConsent(
            @PathVariable Long patientId,
            @PathVariable Long consentId,
            @Valid @RequestBody ConsentRequestDTO request) {
        return ResponseEntity.ok(
                patientService.updateConsent(patientId, consentId, request));
    }

    @DeleteMapping("/{patientId}/consents/{consentId}")
    public ResponseEntity<Void> deleteConsent(
            @PathVariable Long patientId,
            @PathVariable Long consentId) {
        patientService.deleteConsent(patientId, consentId);
        return ResponseEntity.noContent().build();
    }

    // ==================== EMERGENCY CONTACT ====================

    @PostMapping("/{patientId}/emergency-contact")
    public ResponseEntity<EmergencyContactResponseDTO> addEmergencyContact(
            @PathVariable Long patientId,
            @Valid @RequestBody EmergencyContactRequestDTO request) {
        return new ResponseEntity<>(
                patientService.addEmergencyContact(patientId, request), HttpStatus.CREATED);
    }

    @GetMapping("/{patientId}/emergency-contact")
    public ResponseEntity<EmergencyContactResponseDTO> getEmergencyContact(
            @PathVariable Long patientId) {
        return ResponseEntity.ok(patientService.getEmergencyContact(patientId));
    }

    @PutMapping("/{patientId}/emergency-contact")
    public ResponseEntity<EmergencyContactResponseDTO> updateEmergencyContact(
            @PathVariable Long patientId,
            @Valid @RequestBody EmergencyContactRequestDTO request) {
        return ResponseEntity.ok(
                patientService.updateEmergencyContact(patientId, request));
    }

    @DeleteMapping("/{patientId}/emergency-contact")
    public ResponseEntity<Void> deleteEmergencyContact(
            @PathVariable Long patientId) {
        patientService.deleteEmergencyContact(patientId);
        return ResponseEntity.noContent().build();
    }
}