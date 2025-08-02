package com.example.auratests.api.model.request;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class EditPost {

    private int id;
    private String updatedAt;
    private List<String> someJson;
    private String title;
    private String status;
    private Boolean published;
    private int publisher;
}
