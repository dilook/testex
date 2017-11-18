package ru.tinkoff.testex.selenium.pages.common;

import org.openqa.selenium.WebDriver;

/**
 * Created by Di on 16.11.2017.
 */
public class UiForm extends UiFields {

    public UiForm(WebDriver webDriver) {
        super("form", webDriver);
    }

    public UiForm(String firstElementLocator, WebDriver webDriver) {
        super(firstElementLocator, "form", webDriver);
    }


}
