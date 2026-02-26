package com.patient.controller;

import com.patient.client.IAuthServiceFeignClient;
import com.patient.model.dto.client.AuthServiceRegisterRequestDTO;
import com.patient.model.dto.client.AuthServiceRegisterResponseDTO;
import com.patient.model.dto.request.PatientRegisterRequestDTO;
import com.patient.model.dto.request.PatientRequestDTO;
import com.patient.model.dto.response.PatientDetailsDTO;
import com.patient.service.interfaces.IPatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final IPatientService patientService;

    private final IAuthServiceFeignClient authClient;

    @PostMapping
    public ResponseEntity<PatientDetailsDTO> registerPatient(@Valid @RequestBody PatientRegisterRequestDTO request) {

        //use feign client to first save the credential and check whether username exists or all security related config do thosr stuff there
        AuthServiceRegisterResponseDTO authResponse = authClient.register(
                AuthServiceRegisterRequestDTO.builder()
                        .username(request.getUsername())
                        .password(request.getPassword())
                        .role("PATIENT")
                        .build()
        );


        return new ResponseEntity<>(patientService.registerPatient(request), HttpStatus.CREATED);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<PatientDetailsDTO> getPatientById(
            @PathVariable Long patientId) {
        return ResponseEntity.ok(patientService.getPatientById(patientId));
    }

    @GetMapping
    public ResponseEntity<List<PatientDetailsDTO>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @PutMapping("/{patientId}")
    public ResponseEntity<PatientDetailsDTO> updatePatient(
            @PathVariable Long patientId,
            @Valid @RequestBody PatientRegisterRequestDTO request) {
        return ResponseEntity.ok(patientService.updatePatient(patientId, request));
    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long patientId) {
        patientService.deletePatient(patientId);
        return ResponseEntity.noContent().build();
    }
}