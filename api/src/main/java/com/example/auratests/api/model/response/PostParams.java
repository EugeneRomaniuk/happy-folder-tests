package com.example.auratests.api.model.response;

import com.example.auratests.api.model.PostStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostParams {

    private int id;
    private String name;
    private PostStatus status;
    private Boolean published;
    private String updatedAt;
    private Integer publisher;
}
