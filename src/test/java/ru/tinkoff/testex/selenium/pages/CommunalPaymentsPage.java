package ru.tinkoff.testex.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.tinkoff.testex.selenium.pages.common.UiMenu;

/**
 * Created by Di on 16.11.2017.
 */
public class CommunalPaymentsPage extends UiMenu {

    public CommunalPaymentsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css=".payment-page__title_inner")
    public WebElement region;

    public Boolean isRegion(String expectedRegion) {
        return region.getText().equals(expectedRegion);
    }


}
