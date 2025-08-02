package com.example.auratests.api;

public interface ApiClient {

    <RP> RP get(String url, Class<RP> responseType);

    <RQ, RP> RP post(String url, RQ body, Class<RP> responseType);
}
