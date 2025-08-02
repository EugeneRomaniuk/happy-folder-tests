package com.example.auratests.ui.page;

import com.example.auratests.ui.config.properties.UiProperties;
import com.example.auratests.ui.element.ElementFacade;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Getter
@Accessors(fluent = true)
@Component
public class LoginPage extends BasePage {

    private final String appUrl;

    @FindBy(xpath = "//button[text()='Login']")
    private ElementFacade loginButton;

    public LoginPage(WebDriver driver, UiProperties uiProperties) {
        super(driver);
        this.appUrl = uiProperties.getAppUrl();
    }

    public LoginPage open() {
        driver.get(appUrl);
        return this;
    }
}
