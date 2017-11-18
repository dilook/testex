package ru.tinkoff.testex.selenium.pages.common;

import org.openqa.selenium.WebDriver;

/**
 * Created by Di on 16.11.2017.
 */
public class UiItems extends UiList {

    public UiItems(String predicateLocator, WebDriver webDriver) {
        super(predicateLocator, "item", webDriver);
    }
}
