package com.patient.service.implementation;

import com.patient.repository.IEmergencyContactRepository;
import com.patient.service.interfaces.IEmergencyContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmergencyContactServiceImpl implements IEmergencyContactService {

    private final IEmergencyContactRepository emergencyContactRepository;

}
