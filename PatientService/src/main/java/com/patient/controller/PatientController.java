package com.patient.controller;

import com.patient.client.IAuthServiceFeignClient;
import com.patient.client.PatientHttpServiceClient;
import com.patient.model.dto.client.AuthServiceRegisterRequestDTO;
import com.patient.model.dto.client.AuthServiceRegisterResponseDTO;
import com.patient.model.dto.request.PatientRegisterRequestDTO;
import com.patient.model.dto.response.PatientDetailsDTO;
import com.patient.model.dto.response.PatientRegistrationResponseDTO;
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

    private final PatientHttpServiceClient patientHttpServiceClient;

    //since trying to use HttpServiceClient
    //private final IAuthServiceFeignClient authClient;

    /*
    JSON to test this api change your mail accordingly for getting OTP

    {
        "username": "chandra_csi",
        "password": "Moon@2109",
        "firstName": "Chandrasekhar",
        "lastName": "Jena",
        "gender": "Male",
        "birthDate": "2002-12-26",
        "email": "", //put your mail you will get an OTP then verify your account and activate using otp
        "phoneNumber": "1234567890",
        "address": "Brahmapur, Nandapur, Bantala",
        "city": "Angul",
        "state": "Odisha",
        "insuranceProvider": "Star Health Insurance",
        "insuranceNumber": "SH-2024-78946",
        "insuranceType": "COMPREHENSIVE"
    }

    Response is :
    {
        "message": "Patient registered successfully!",
        "username": "chandra_csi"
    }

    MetaData : 201 Created  196ms   71B

     */
    @PostMapping("/register")
    public ResponseEntity<PatientRegistrationResponseDTO> registerPatient(@Valid @RequestBody PatientRegisterRequestDTO request) {


        try {
            System.out.println("Class of Patient Service :");
            AuthServiceRegisterResponseDTO patient = patientHttpServiceClient.register(
                    AuthServiceRegisterRequestDTO.builder()
                            .username(request.getUsername())
                            .password(request.getPassword())
                            .email(request.getEmail())
                            .role("PATIENT")
                            .build()
            );
        }
        catch (Exception e) {
            System.out.println( e.getMessage() );
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        /*
        //use feign client to first save the credential and check whether username exists or all security related config do thosr stuff there
        AuthServiceRegisterResponseDTO authResponse = authClient.register(
                AuthServiceRegisterRequestDTO.builder()
                        .username(request.getUsername())
                        .password(request.getPassword())
                        .email(request.getEmail())
                        .role("PATIENT")
                        .build()
        );


        */

        return new ResponseEntity<>(patientService.registerPatient(request), HttpStatus.CREATED);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<PatientDetailsDTO> getPatientById(
            @PathVariable Long patientId) {
        return ResponseEntity.ok(patientService.getPatientById(patientId));
    }

    @GetMapping("/all-patients")
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