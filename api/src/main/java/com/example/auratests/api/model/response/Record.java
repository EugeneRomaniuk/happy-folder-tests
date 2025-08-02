package com.example.auratests.api.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.Map;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Record<T> {

    private T params;
    private Map<String, Object> populated;
    private Object baseError;
    private Map<String, Object> errors;
    private int id;
    private String title;
}
