package com.patient.config;

import com.patient.client.PatientHttpServiceClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.service.registry.ImportHttpServices;

@Configuration
@ImportHttpServices(basePackages = "com.patient.client")
public class HttpServiceClientConfig {
}
