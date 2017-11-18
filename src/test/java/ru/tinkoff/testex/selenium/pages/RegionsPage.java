package ru.tinkoff.testex.selenium.pages;

import org.openqa.selenium.WebDriver;
import ru.tinkoff.testex.selenium.pages.common.UiItems;

/**
 * Created by Di on 16.11.2017.
 */
public class RegionsPage extends UiItems {

    public RegionsPage(WebDriver webDriver) {
        super("regions", webDriver);
    }

    @Override
    public void selectUiItemByText(String regionName) {
        super.selectUiItemByText(regionName);
    }

}
