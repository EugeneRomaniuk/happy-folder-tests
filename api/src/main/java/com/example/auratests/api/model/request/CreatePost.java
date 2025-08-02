package com.example.auratests.api.model.request;

import com.example.auratests.api.model.PostStatus;
import lombok.*;

@Getter
@Builder
public class CreatePost {

        private PostStatus status;
        private Boolean published;
        private String title;
        private int publisher;
}
