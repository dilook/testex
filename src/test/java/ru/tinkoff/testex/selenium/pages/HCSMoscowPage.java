package ru.tinkoff.testex.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.tinkoff.testex.selenium.pages.common.UiFrame;

/**
 * Created by Di on 16.11.2017.
 */
public class HCSMoscowPage extends UiFrame {

    public HCSMoscowPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }


    @FindBy(linkText = "Оплатить ЖКУ в Москве")
    public WebElement payTab;


}
