package com.example.auratests.ui.page.post;

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
public class PostViewPage extends BasePage {

    @FindBy(xpath = "//a[@data-testid='action-edit']")
    private ElementFacade editPostButton;

    @FindBy(xpath = "//section[@data-testid='property-show-status']//span[contains(@class, 'adminjs_Badge')]")
    private ElementFacade postStatusText;

    @FindBy(xpath = "//section[@data-testid='property-show-published']//span[contains(@class, 'adminjs_Badge')]")
    private ElementFacade postPublishedStatusText;

    public PostViewPage(WebDriver driver) {
        super(driver);
    }
}
