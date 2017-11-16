package ru.tinkoff.testex.selenium.pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Di on 16.11.2017.
 */
@FindBy(css = ".ui-page-frame")
public class UiFrame extends Page {

    public UiFrame(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }
}
