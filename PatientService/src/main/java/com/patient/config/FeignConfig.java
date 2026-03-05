package com.patient.config;

import com.patient.errordecoder.CustomFeignErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public ErrorDecoder feignDecoder() {
        return new CustomFeignErrorDecoder();
    }


}
