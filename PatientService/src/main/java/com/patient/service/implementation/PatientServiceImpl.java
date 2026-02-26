package com.patient.service.implementation;

import com.patient.exception.PatientNotFoundException;
import com.patient.model.dto.request.PatientRegisterRequestDTO;
import com.patient.model.dto.request.PatientRequestDTO;
import com.patient.model.dto.response.PatientDetailsDTO;
import com.patient.model.entity.Patient;
import com.patient.repository.IPatientRepository;
import com.patient.service.interfaces.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PatientServiceImpl implements IPatientService {

    private final IPatientRepository patientRepository;

    @Override
    public PatientDetailsDTO registerPatient(PatientRegisterRequestDTO request) {

        Patient patient = mapToEntity(request);
        Patient saved = patientRepository.save(patient);
        return mapToResponseDTO(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public PatientDetailsDTO getPatientById(Long patientId) {
        Patient patient = findPatientOrThrow(patientId);
        return mapToResponseDTO(patient);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PatientDetailsDTO> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PatientDetailsDTO updatePatient(Long patientId, PatientRegisterRequestDTO request) {
        Patient patient = findPatientOrThrow(patientId);

        patient.setFirstName(request.getFirstName());
        patient.setLastName(request.getLastName());
        patient.setBirthDate(request.getBirthDate());
        patient.setEmail(request.getEmail());
        patient.setPhoneNumber(request.getPhoneNumber());
        patient.setAddress(request.getAddress());
        patient.setCity(request.getCity());
        patient.setState(request.getState());
        patient.setInsuranceProvider(request.getInsuranceProvider());
        patient.setInsuranceNumber(request.getInsuranceNumber());
        patient.setInsuranceType(request.getInsuranceType());

        Patient updated = patientRepository.save(patient);
        return mapToResponseDTO(updated);
    }

    @Override
    public void deletePatient(Long patientId) {
        Patient patient = findPatientOrThrow(patientId);
        patientRepository.delete(patient);
    }

    @Override
    @Transactional(readOnly = true)
    public Patient findPatientOrThrow(Long patientId) {
        return patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException(
                        "Patient not found with id: " + patientId));
    }

    // ========== MAPPER METHODS ==========

    private Patient mapToEntity(PatientRegisterRequestDTO request) {
        Patient patient = new Patient();
        patient.setFirstName(request.getFirstName());
        patient.setLastName(request.getLastName());
        patient.setBirthDate(request.getBirthDate());
        patient.setEmail(request.getEmail());
        patient.setPhoneNumber(request.getPhoneNumber());
        patient.setAddress(request.getAddress());
        patient.setCity(request.getCity());
        patient.setState(request.getState());
        patient.setInsuranceProvider(request.getInsuranceProvider());
        patient.setInsuranceNumber(request.getInsuranceNumber());
        patient.setInsuranceType(request.getInsuranceType());
        return patient;
    }

    private PatientDetailsDTO mapToResponseDTO(Patient patient) {
        return PatientDetailsDTO.builder()
                .patientId(patient.getPatientId())
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .birthDate(patient.getBirthDate())
                .email(patient.getEmail())
                .phoneNumber(patient.getPhoneNumber())
                .address(patient.getAddress())
                .city(patient.getCity())
                .state(patient.getState())
                .insuranceProvider(patient.getInsuranceProvider())
                .insuranceNumber(patient.getInsuranceNumber())
                .insuranceType(patient.getInsuranceType())
                .createdAt(patient.getCreatedAt())
                .build();
    }
}
