package com.example.auratests.api.model.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreatePublisher {

    private final String name;
    private final String email;
}
