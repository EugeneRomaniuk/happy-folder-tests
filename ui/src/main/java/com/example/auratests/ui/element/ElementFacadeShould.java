package com.example.auratests.ui.element;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Slf4j
public class ElementFacadeShould extends AbstractElementFacade {

    private final ElementFacade elementFacade;

    public ElementFacadeShould(ElementFacade elementFacade) {
        super(elementFacade.name, elementFacade.driver, elementFacade.by);
        this.elementFacade = elementFacade;
    }

    public ElementFacade beVisible() {
        return beVisible(Duration.ofSeconds(5));
    }

    public ElementFacade haveText(String expectedText) {
        log.info("Expecting element {} to have text '{}'", getLogName(), expectedText);
        var actualText = elementFacade.getText();
        Assertions.assertThat(actualText)
                .as("Expected element %s to have text", getLogName())
                .isEqualTo(expectedText);
        return elementFacade;
    }

    public ElementFacade beVisible(Duration timeout) {
        log.info("Waiting for element {} to be visible in {}", getLogName(), timeout);
        try {
            var wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return elementFacade;
        } catch (TimeoutException ex) {
            throw new AssertionError(String.format("Element %s doesn't exist or not visible by locator: ", getLogName()), ex);
        }
    }
}
