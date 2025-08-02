package com.example.auratests.api;

import com.example.auratests.api.model.PostStatus;
import com.example.auratests.api.config.MainConfig;
import com.example.auratests.api.model.request.EditPost;
import net.bytebuddy.utility.RandomString;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest(classes = MainConfig.class)
public class CreatePostAndEditApiTest {

    @Autowired
    private TestApplicationService testApplicationService;

    @Test
    public void createPostAndEditTest() {

        // Step 1: Create a Publisher using API
        final String name = "auto_" + RandomString.make(10);
        final String email = RandomString.make(10) + "@email.com";
        var publisher = testApplicationService.createPublisher(name, email);

        // Step 2: Create a Post using API
        var post = testApplicationService.createPost(publisher.getRecord().getId());
        var postParams = post.getRecord().getParams();

        // Step 3: Link to the Publisher created( Status= Active, Published= True)
        Assertions.assertThat(postParams.getStatus()).as("Post should have status")
                .isEqualTo(PostStatus.ACTIVE);
        Assertions.assertThat(postParams.getPublished()).as("Post is published")
                .isEqualTo(true);

        // Step 4 & 5: Edit Post - Change status to remove and save
        var postId = postParams.getId();
        var editPost = EditPost.builder()
                .id(postId)
                .publisher(postParams.getPublisher())
                .updatedAt(LocalDateTime.now().toString())
                .published(true)
                .someJson(List.of("{}"))  // Json value is required, but can be any valid JSON string.
                .title(post.getRecord().getTitle())
                .status(PostStatus.REMOVED.name())
                .build();
        testApplicationService.editPost(editPost);

        // Step 6: Validate post status was changed to Remove from the Post page
        var posts = testApplicationService.getPosts().getRecords();
        var foundedPost = posts.stream()
                .filter(it -> it.getId() == postId)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(String.format("Post with id=%d was not found", postId)));
        Assertions.assertThat(foundedPost.getParams().getStatus()).as("Updated Post should have status")
                .isEqualTo(PostStatus.REMOVED);
    }

    @AfterEach
    public void cleanUp() {
        //Here could be the logic to clean up created entities
    }
}
