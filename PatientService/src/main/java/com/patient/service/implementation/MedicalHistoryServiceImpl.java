package com.patient.service.implementation;

import com.patient.repository.IMedicalHistoryRepository;
import com.patient.service.interfaces.IMedicalHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicalHistoryServiceImpl implements IMedicalHistoryService {

    private final IMedicalHistoryRepository medicalHistoryRepository;

}
