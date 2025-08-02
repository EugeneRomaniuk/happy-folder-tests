package com.example.auratests.api.config;

import com.example.auratests.api.ApiClient;
import com.example.auratests.api.RestTemplateApiClient;
import com.example.auratests.api.TestApplicationService;
import com.example.auratests.api.config.properties.ApiProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Configuration
public class ApiConfig {

    @Bean
    public TestApplicationService testApplicationService(ApiClient apiClient, ApiProperties properties) {
        return new TestApplicationService(apiClient, properties.getAppUrl());
    }

    @Bean
    public ApiClient apiClient(RestTemplate restTemplate, ApiProperties properties) {
        return new RestTemplateApiClient(restTemplate, properties.getAdminJs());
    }

    @Bean
    public RestTemplate restTemplate() {
        var restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add((request, body, execution) -> {
            log.info("Request {} {}", request.getMethod(), request.getURI());
            return execution.execute(request, body);
        });
        return restTemplate;
    }
}
