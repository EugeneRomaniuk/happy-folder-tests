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
abstract class BasePostCreateEditPage extends BasePage {

    @FindBy(xpath = "//input[@id='title']")
    protected ElementFacade titleTextInput;

    @FindBy(xpath = "//button[@data-testid='someJson-add']")
    protected ElementFacade someJsonAddNewItemButton;

    @FindBy(xpath = "//section[@data-testid='property-edit-status']//div[contains(@class, 'css-uayuwa-Input')]")
    protected ElementFacade postStatusInput;

    @FindBy(xpath = "//div[contains(@class, 'option') and text()='ACTIVE']")
    protected ElementFacade postStatusActiveDropdownOption;

    @FindBy(xpath = "//div[contains(@class, 'option') and text()='REMOVED']")
    protected ElementFacade postStatusRemovedDropdownOption;

    @FindBy(xpath = "//input[@id='published']/following-sibling::a")
    protected ElementFacade postPublishedCheckBox;

    @FindBy(xpath = "//section[@data-testid='property-edit-publisher']//div[contains(@class, 'css-uayuwa-Input')]")
    protected ElementFacade linkToPublisherInput;

    @FindBy(xpath = "//button[@data-testid='button-save']")
    protected ElementFacade savePostButton;

    public BasePostCreateEditPage(WebDriver driver) {
        super(driver);
    }

    public ElementFacade publisherDropdownValueByText(String text) {
        return new ElementFacade(String.format("publisherDropdownOption[%s]", text),
                driver, By.xpath(String.format("//div[contains(@class, 'option') and text()='%s']", text)));
    }
}
