package ru.tinkoff.testex.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.tinkoff.testex.selenium.pages.common.Page;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static ru.tinkoff.testex.selenium.WebDriverTestUtils.baseUrl;

/**
 * Created by Di on 15.11.2017.
 */
public class MainPage extends Page {

    public MenuBar menuBar;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public MainPage open() {
        webDriver.get(baseUrl);
        webDriverWait.until(titleIs("Лучший онлайн-банк. Кредитные и дебетовые карты с доставкой на дом."));
        return this;
    }
}
