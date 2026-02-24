package com.patient.service.implementation;

import com.patient.repository.IVisitRepository;
import com.patient.service.interfaces.IVisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitServiceImpl implements IVisitService {

    private final IVisitRepository visitRepository;

}
