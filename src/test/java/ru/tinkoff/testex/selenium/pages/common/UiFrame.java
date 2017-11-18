package ru.tinkoff.testex.selenium.pages.common;

import org.openqa.selenium.WebDriver;

/**
 * Created by Di on 18.11.2017.
 */
public class UiFrame extends UiForm {

    public UiFrame(WebDriver webDriver) {
        super(".ui-page-frame", webDriver);
    }
}
