package ru.tinkoff.testex.selenium.pages.common;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Di on 16.11.2017.
 */
@FindBy(css = ".ui-loader")
public class Loader extends RemoteWebElement {
}
