package ru.tinkoff.testex.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.tinkoff.testex.selenium.pages.common.Page;

import java.util.List;

/**
 * Created by Di on 15.11.2017.
 */
@FindBy(id = "mainMenu")
public class MenuBar extends Page {
    private static final Logger LOGGER = Logger.getLogger(MenuBar.class);
    @FindBy(css = "[data-menu-item]")
    List<WebElement> menuItems;

    public MenuBar(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void goTo(String itemName) {
        Boolean found = false;
        for (WebElement item : menuItems) {
            if (item.getText().equals(itemName)) {
                item.click();
                found = true;
                break;
            }
        }

        String message = found ? "Переход в пункт меню \"" + itemName + "\""
                : "Пункт меню \"" + itemName + "\" не найден";

        LOGGER.info(message);
    }
}
