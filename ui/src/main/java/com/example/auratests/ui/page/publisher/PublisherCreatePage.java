package com.example.auratests.ui.page.publisher;

import com.example.auratests.ui.element.ElementFacade;
import com.example.auratests.ui.page.BasePage;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Getter
@Accessors(fluent = true)
@Component
public class PublisherCreatePage extends BasePage {

    @FindBy(xpath = "//input[@name='name']")
    private ElementFacade publisherNameTextInput;

    @FindBy(xpath = "//input[@name='email']")
    private ElementFacade publisherEmailTextInput;

    @FindBy(xpath = "//button[@data-testid='button-save']")
    private ElementFacade savePublisherButton;

    public PublisherCreatePage(WebDriver driver) {
        super(driver);
    }
}
