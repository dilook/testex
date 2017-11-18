package ru.tinkoff.testex.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.tinkoff.testex.selenium.pages.common.UiFrame;

/**
 * Created by Di on 16.11.2017.
 */
public class HCSMoscowPage extends UiFrame {

    public HCSMoscowPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement payTab() {
        return webDriver.findElement(By.xpath("//*[contains(text(), 'Оплатить ЖКУ в Москве')]"));
    }

    public WebElement payButton() {
        return webDriver.findElement(By.xpath("//h2[contains(text(), 'Оплатить ЖКУ в Москве')]/.."));
    }

    public WebElement providerPayerCode() {
        webDriverWait.until(ExpectedConditions.visibilityOf(payButton()));
        return webDriver.findElement(By.cssSelector("[name='provider-payerCode']"));
    }


}
