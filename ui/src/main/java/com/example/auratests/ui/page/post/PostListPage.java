package com.example.auratests.ui.page.post;

import com.example.auratests.ui.element.ElementFacade;
import com.example.auratests.ui.page.BasePage;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Getter
@Accessors(fluent = true)
@Component
public class PostListPage extends BasePage {

    @FindBy(xpath = "//a[@data-testid='action-new' and @data-css='Post-new-button']")
    private ElementFacade createPostButton;

    public PostListPage(WebDriver driver) {
        super(driver);
    }

    public ElementFacade postViewLinkWithTitle(String title) {
        return new ElementFacade(String.format("postViewLinkByTitle[%s]", title),
                driver, By.xpath(String.format("//section[@data-testid='property-list-title' and text()='%s']//ancestor::tr", title)));
    }

    public ElementFacade postStatusWithTitle(String title) {
        return new ElementFacade(String.format("postStatusText[%s]", title),
                driver, By.xpath(String.format("//section[@data-testid='property-list-title' and text()='%s']" +
                "//ancestor::tr//span[contains(@class, 'adminjs_Badge')]", title)));
    }
}
