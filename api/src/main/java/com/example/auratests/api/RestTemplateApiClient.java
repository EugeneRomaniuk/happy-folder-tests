package com.example.auratests.api;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public class RestTemplateApiClient implements ApiClient {

    private final RestTemplate restTemplate;
    private final String adminJsCookie;

    @Override
    public <T> T get(String url, Class<T> responseType) {
        var responseEntity = restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(null), responseType);
        validateResponse(responseEntity);
        return responseEntity.getBody();
    }

    @Override
    public <RQ, RS> RS post(String url, RQ body, Class<RS> responseType) {
        var responseEntity = restTemplate.exchange(url, HttpMethod.POST, getRequestEntity(body), responseType);
        validateResponse(responseEntity);
        return responseEntity.getBody();
    }

    private <RQ> HttpEntity<RQ> getRequestEntity(RQ body) {
        var headers = new HttpHeaders();
        headers.add("Cookie", adminJsCookie);
        headers.setContentType(MediaType.APPLICATION_JSON);
        if (body == null) {
            return new HttpEntity<>(headers);
        }
        return new HttpEntity<>(body, headers);
    }

    private <RS> void validateResponse(ResponseEntity<RS> response) {
        Assertions.assertThat(response.getStatusCode().is2xxSuccessful())
                .withFailMessage("Unexpected status code: %s", response.getStatusCode())
                .isTrue();
        Assertions.assertThat(response.hasBody())
                .withFailMessage("Response body is null")
                .isTrue();
    }
}
