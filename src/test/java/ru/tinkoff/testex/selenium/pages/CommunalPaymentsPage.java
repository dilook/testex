package ru.tinkoff.testex.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.tinkoff.testex.selenium.pages.common.UiMenu;

/**
 * Created by Di on 16.11.2017.
 */
public class CommunalPaymentsPage extends UiMenu {

    public CommunalPaymentsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement region() {
        webDriverWait.until(ExpectedConditions.titleContains("Коммунальные платежи"));
        return webDriver.findElement(By.cssSelector(".payment-page__title_inner"));
    }

}
