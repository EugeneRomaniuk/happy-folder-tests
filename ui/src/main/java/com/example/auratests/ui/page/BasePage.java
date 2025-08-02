package com.example.auratests.ui.page;

import com.example.auratests.ui.element.ElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BasePage {

    protected final WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        initializeElementFacades();
    }

    private void initializeElementFacades() {
        for (var field : getFieldsIncludingSuperclasses(this.getClass())) {
            if (field.isAnnotationPresent(FindBy.class) && field.getType().equals(ElementFacade.class)) {
                var findBy = field.getAnnotation(FindBy.class);
                var by = buildByFromFindBy(findBy);
                try {
                    field.setAccessible(true);
                    var element = new ElementFacade(field.getName(), driver, by);
                    field.set(this, element);
                } catch (IllegalAccessException ex) {
                    throw new RuntimeException("Failed to set field: " + field.getName(), ex);
                }
            }
        }
    }

    private List<Field> getFieldsIncludingSuperclasses(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();
        while (clazz != null && clazz != Object.class) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        return fields;
    }

    private By buildByFromFindBy(FindBy findBy) {
        if (!findBy.xpath().isEmpty()) {
            return By.xpath(findBy.xpath());
        }
        throw new IllegalArgumentException(String.format("Not implemented @FindBy locator: %s.\n" +
                "Add implementation for wanted type.", findBy));
    }
}
