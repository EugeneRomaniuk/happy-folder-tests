package com.example.auratests.ui.element;

import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@AllArgsConstructor
abstract class AbstractElementFacade {

    protected String name;
    protected WebDriver driver;
    protected By by;

    protected String getLogName() {
        return String.format("%s[%s]", name, by);
    }
}
