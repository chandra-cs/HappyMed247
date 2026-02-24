package com.patient.service.implementation;

import com.patient.repository.IMedicalDocumentRepository;
import com.patient.service.interfaces.IMedicalDocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicalDocumentServiceImpl implements IMedicalDocumentService {

    private final IMedicalDocumentRepository medicalDocumentRepository;

}
