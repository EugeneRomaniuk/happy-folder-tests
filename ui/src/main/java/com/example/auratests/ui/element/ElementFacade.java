package com.example.auratests.ui.element;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Slf4j
public class ElementFacade extends AbstractElementFacade {

    public ElementFacade(String name, WebDriver driver, By by) {
        super(name, driver, by);
    }

    public ElementFacadeShould should() {
        return new ElementFacadeShould(this);
    }

    public ElementFacade click() {
        log.info("Clicking on element: {}", getLogName());
        driver.findElement(by).click();
        return this;
    }

    public String getText() {
        log.info("Getting text from element: {}", getLogName());
        return driver.findElement(by).getText();
    }

    public ElementFacade sendText(String text) {
        log.info("Sending text '{}' to element: {}", text, getLogName());
        driver.findElement(by).sendKeys(text);
        return this;
    }
}
