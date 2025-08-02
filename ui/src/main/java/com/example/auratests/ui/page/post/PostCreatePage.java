package com.example.auratests.ui.page.post;

import com.example.auratests.ui.element.ElementFacade;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Getter
@Accessors(fluent = true)
@Component
public class PostCreatePage extends BasePostCreateEditPage {

    @FindBy(xpath = "//h2[text()='Create new']")
    private ElementFacade createNewPostHeader;

    public PostCreatePage(WebDriver driver) {
        super(driver);
    }
}
