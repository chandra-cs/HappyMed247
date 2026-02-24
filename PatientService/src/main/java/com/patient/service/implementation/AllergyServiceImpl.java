package com.patient.service.implementation;

import com.patient.repository.IAllergyRepository;
import com.patient.service.interfaces.IAllergyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AllergyServiceImpl implements IAllergyService {

    private final IAllergyRepository allergyRepository;

}
