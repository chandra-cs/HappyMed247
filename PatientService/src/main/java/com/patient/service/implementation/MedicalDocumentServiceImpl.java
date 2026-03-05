package com.patient.service.implementation;

import com.patient.exception.DocumentNotFoundException;
import com.patient.model.dto.request.MedicalDocumentRequestDTO;
import com.patient.model.dto.response.MedicalDocumentResponseDTO;
import com.patient.model.entity.MedicalDocument;
import com.patient.model.entity.Patient;
import com.patient.repository.IMedicalDocumentRepository;
import com.patient.service.interfaces.IMedicalDocumentService;
import com.patient.service.interfaces.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class MedicalDocumentServiceImpl implements IMedicalDocumentService {

    private final IMedicalDocumentRepository medicalDocumentRepository;
    private final IPatientService patientService;

    @Override
    public MedicalDocumentResponseDTO addDocument(Long patientId, MedicalDocumentRequestDTO request) {
        Patient patient = patientService.findPatientOrThrow(patientId);

        MedicalDocument document = new MedicalDocument();
        document.setFileName(request.getFileName());
        document.setFilePath(request.getFilePath());
        document.setPatient(patient);

        MedicalDocument saved = medicalDocumentRepository.save(document);
        return mapToResponseDTO(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MedicalDocumentResponseDTO> getDocuments(Long patientId) {
        patientService.findPatientOrThrow(patientId);
        return medicalDocumentRepository.findByPatientPatientId(patientId)
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteDocument(Long patientId, Long documentId) {
        patientService.findPatientOrThrow(patientId);
        MedicalDocument document = medicalDocumentRepository
                .findByIdAndPatientPatientId(documentId, patientId)
                .orElseThrow(() -> new DocumentNotFoundException(
                        "Document not found with id: " + documentId
                                + " for patient: " + patientId));
        medicalDocumentRepository.delete(document);
    }

    private MedicalDocumentResponseDTO mapToResponseDTO(MedicalDocument document) {
        return MedicalDocumentResponseDTO.builder()
                .id(document.getId())
                .fileName(document.getFileName())
                .filePath(document.getFilePath())
                .build();
    }
}