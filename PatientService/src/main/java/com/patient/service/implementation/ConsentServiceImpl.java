package com.patient.service.implementation;

import com.patient.repository.IAllergyRepository;
import com.patient.repository.IConsentRepository;
import com.patient.service.interfaces.IAllergyService;
import com.patient.service.interfaces.IConsentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsentServiceImpl implements IConsentService {

    private final IConsentRepository allergyRepository;


}
