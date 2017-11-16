package ru.tinkoff.testex.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.tinkoff.testex.selenium.pages.common.UiList;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;

/**
 * Created by Di on 16.11.2017.
 */
public class RegionsPage extends UiList {

    public RegionsPage(WebDriver webDriver) {
        super("regions", webDriver);
    }

    @Override
    public void selectUiItemByText(String regionName){
        super.selectUiItemByText(regionName);
        webDriverWait.until(invisibilityOfElementLocated(By.cssSelector(".ui-modal__container_regions")));
    }

}
