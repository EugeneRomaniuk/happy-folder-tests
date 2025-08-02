package com.example.auratests.api;

import com.example.auratests.api.model.PostStatus;
import com.example.auratests.api.model.request.CreatePost;
import com.example.auratests.api.model.request.CreatePublisher;
import com.example.auratests.api.model.request.EditPost;
import com.example.auratests.api.model.response.Post;
import com.example.auratests.api.model.response.Publisher;
import com.example.auratests.api.model.response.Posts;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.RandomString;

@RequiredArgsConstructor
public class TestApplicationService {

    private final ApiClient apiClient;
    private final String url;

    public Publisher createPublisher(String name, String email) {
        String endpoint = "/api/resources/Publisher/actions/new";
        var request = new CreatePublisher(name, email);
        return apiClient.post(url + endpoint, request, Publisher.class);
    }

    public Post createPost(int publisherId) {
        var endpoint = "/api/resources/Post/actions/new";
        var request = CreatePost.builder()
                .publisher(publisherId)
                .published(true)
                .status(PostStatus.ACTIVE)
                .title("Autotest API " + RandomString.make(10))
                .build();
        return apiClient.post(url + endpoint, request, Post.class);
    }

    public Post editPost(EditPost post) {
        var endpoint = "/api/resources/Post/records/%d/edit";
        var urlWithId = String.format(url + endpoint, post.getId());
        return apiClient.post(urlWithId, post, Post.class);
    }

    public Posts getPosts() {
        var endpoint = "/api/resources/Post/actions/list";
        return apiClient.get(url + endpoint, Posts.class);
    }
}
