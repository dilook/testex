package ru.tinkoff.testex.selenium.pages.common;

import org.openqa.selenium.WebDriver;

/**
 * Created by Di on 16.11.2017.
 */
public class UiMenu extends UiList {

    public UiMenu(WebDriver webDriver) {
        super("menu", webDriver);
    }
}
