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
public class PublisherListPage extends BasePage {

    @FindBy(xpath = "//a[@data-testid='action-new' and @data-css='Publisher-new-button']")
    private ElementFacade createPublisherButton;

    public PublisherListPage(WebDriver driver) {
        super(driver);
    }
}