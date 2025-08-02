package com.example.auratests.ui.page;

import com.example.auratests.ui.element.ElementFacade;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Getter
@Accessors(fluent = true)
@Component
public class MenuSideBar extends BasePage {

    @FindBy(xpath = "//div[text()='Happy Folder']")
    private ElementFacade happyFolderButton;

    @FindBy(xpath = "//div[text()='Publisher']")
    private ElementFacade publisherLink;

    @FindBy(xpath = "//div[text()='Profile']")
    private ElementFacade profileLink;

    @FindBy(xpath = "//div[text()='Post']")
    private ElementFacade postLink;

    public MenuSideBar(WebDriver driver) {
        super(driver);
    }
}
