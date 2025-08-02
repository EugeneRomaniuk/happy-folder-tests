package com.example.auratests.api;

import com.example.auratests.ui.config.MainConfig;
import com.example.auratests.ui.page.LoginPage;
import com.example.auratests.ui.page.MenuSideBar;
import com.example.auratests.ui.page.post.PostCreatePage;
import com.example.auratests.ui.page.post.PostEditPage;
import com.example.auratests.ui.page.post.PostListPage;
import com.example.auratests.ui.page.post.PostViewPage;
import com.example.auratests.ui.page.publisher.PublisherCreatePage;
import com.example.auratests.ui.page.publisher.PublisherListPage;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest(classes = MainConfig.class)
public class CreatePostAndEditUiTest {

    private static final String POST_STATUS_ACTIVE = "ACTIVE";
    private static final String POST_STATUS_REMOVED = "REMOVED";
    private static final String POST_PUBLISHED_YES = "Yes";

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private MenuSideBar menuSideBar;

    @Autowired
    private PublisherListPage publisherListPage;

    @Autowired
    private PublisherCreatePage publisherCreatePage;

    @Autowired
    private PostListPage postListPage;

    @Autowired
    private PostCreatePage postCreatePage;

    @Autowired
    private PostViewPage postViewPage;

    @Autowired
    private PostEditPage postEditPage;

    @Test
    public void createPostAndEditTest() {

        // Precondition: Login to the application
        loginPage.open().loginButton().should().beVisible().click();
        menuSideBar.happyFolderButton().should().beVisible().click();

        // Step 1: Create Publisher entity
        menuSideBar.publisherLink().should().beVisible().click();
        publisherListPage.createPublisherButton().should().beVisible().click();
        final String name = "auto_" + RandomString.make(10);
        publisherCreatePage.publisherNameTextInput().should().beVisible().sendText(name);
        final String email = RandomString.make(10) + "@mail.com";
        publisherCreatePage.publisherEmailTextInput().should().beVisible().sendText(email);
        publisherCreatePage.savePublisherButton().should().beVisible().click();

        // Step 2: Create Post entity
        menuSideBar.postLink().should().beVisible().click();
        postListPage.createPostButton().should().beVisible().click();
        postCreatePage.createNewPostHeader().should().beVisible();
        final String postTitle = "Autotest UI  " + RandomString.make(10);
        postCreatePage.titleTextInput().should().beVisible().sendText(postTitle);
        postCreatePage.postPublishedCheckBox().should().beVisible().click();
        postCreatePage.postStatusInput().should().beVisible().click();
        postCreatePage.postStatusActiveDropdownOption().should().beVisible().click();
        postCreatePage.linkToPublisherInput().should().beVisible().click();
        postCreatePage.publisherDropdownValueByText(email).should().beVisible().click();
        postCreatePage.savePostButton().should().beVisible().click();

        // Step 3: Link to the Publisher created( Status= Active, Published= True)
        postListPage.postViewLinkWithTitle(postTitle).should().beVisible().click();
        postViewPage.postStatusText().should().beVisible().should().haveText(POST_STATUS_ACTIVE);
        postViewPage.postPublishedStatusText().should().haveText(POST_PUBLISHED_YES);

        // Step 4: Edit Post - Change status to remove
        postViewPage.editPostButton().click();
        postEditPage.editPostHeader().should().beVisible();
        postEditPage.someJsonAddNewItemButton().should().beVisible().click();
        postEditPage.postStatusInput().should().beVisible().click();
        postEditPage.postStatusRemovedDropdownOption().should().beVisible().click();

        // Step 5: Save
        postEditPage.savePostButton().should().beVisible().click();

        // Step 6: Validate post status was changed to Remove from the Post page
        postListPage.postStatusWithTitle(postTitle).should().beVisible().should().haveText(POST_STATUS_REMOVED);
        postListPage.postViewLinkWithTitle(postTitle).should().beVisible().click();
        postViewPage.postStatusText().should().beVisible().should().haveText(POST_STATUS_REMOVED);
    }

    @AfterEach
    public void cleanUp() {
        //Here could be a logic to clean up created entities
    }
}
