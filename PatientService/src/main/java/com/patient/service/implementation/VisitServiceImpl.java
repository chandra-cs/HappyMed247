package com.patient.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import com.patient.exception.VisitNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patient.model.dto.request.VisitRequestDTO;
import com.patient.model.dto.response.VisitResponseDTO;
import com.patient.model.entity.Patient;
import com.patient.model.entity.Visit;
import com.patient.repository.IVisitRepository;
import com.patient.service.interfaces.IPatientService;
import com.patient.service.interfaces.IVisitService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class VisitServiceImpl implements IVisitService {

    private final IVisitRepository visitRepository;
    private final IPatientService patientService;

    @Override
    public VisitResponseDTO addVisit(Long patientId, VisitRequestDTO request) {
        Patient patient = patientService.findPatientOrThrow(patientId);

        Visit visit = new Visit();
        visit.setVisitDate(request.getVisitDate());
        visit.setReason(request.getReason());
        visit.setNotes(request.getNotes());
        visit.setPatient(patient);

        Visit saved = visitRepository.save(visit);
        return mapToResponseDTO(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<VisitResponseDTO> getVisits(Long patientId) {
        patientService.findPatientOrThrow(patientId);
        return visitRepository.findByPatientPatientId(patientId)
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VisitResponseDTO updateVisit(Long patientId, Long visitId, VisitRequestDTO request) {
        patientService.findPatientOrThrow(patientId);
        Visit visit = findVisitOrThrow(patientId, visitId);

        visit.setVisitDate(request.getVisitDate());
        visit.setReason(request.getReason());
        visit.setNotes(request.getNotes());

        Visit updated = visitRepository.save(visit);
        return mapToResponseDTO(updated);
    }

    @Override
    public void deleteVisit(Long patientId, Long visitId) {
        patientService.findPatientOrThrow(patientId);
        Visit visit = findVisitOrThrow(patientId, visitId);
        visitRepository.delete(visit);
    }

    private Visit findVisitOrThrow(Long patientId, Long visitId) {
        return visitRepository.findByVisitIdAndPatientPatientId(visitId, patientId)
                .orElseThrow(() -> new VisitNotFoundException(
                        "Visit not found with id: " + visitId
                                + " for patient: " + patientId));
    }

    private VisitResponseDTO mapToResponseDTO(Visit visit) {
        return VisitResponseDTO.builder()
                .visitId(visit.getVisitId())
                .visitDate(visit.getVisitDate())
                .reason(visit.getReason())
                .notes(visit.getNotes())
                .build();
    }
}
