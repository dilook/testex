package ru.tinkoff.testex.selenium.pages.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by Di on 16.11.2017.
 */
public class UiList extends Page {
    private static final Logger LOGGER = Logger.getLogger(UiList.class);

    private String predicateLocator;
    private String postfixLocator;
    private String firstElementLocator = "";

    public UiList(String predicateLocator, String postfixLocator, WebDriver webDriver) {
        super(webDriver);
        this.predicateLocator = predicateLocator;
        this.postfixLocator = postfixLocator;
    }

    //конструктор для UiFrame
    public UiList(String firsElementLocator, String predicateLocator, String postfixLocator, WebDriver webDriver) {
        this(predicateLocator, postfixLocator, webDriver);
        this.firstElementLocator = firsElementLocator;
    }

    /**
     * Метод возвращает все пункты на странице
     *
     * @return
     */
    public List<WebElement> uiItems() {
        if (firstElementLocator.isEmpty()) {
            webDriverWait.until(visibilityOfElementLocated(By.cssSelector(".ui-" + predicateLocator)));
            return webDriver.findElements(By.cssSelector(".ui-" + predicateLocator + "__" + postfixLocator));
        } else {
            webDriverWait.until(visibilityOfElementLocated(By.cssSelector(firstElementLocator + " .ui-" + predicateLocator)));
            return webDriver.findElements(By.cssSelector(firstElementLocator + " .ui-" + predicateLocator + "__" + postfixLocator));
        }
    }

    /**
     * Метод ищет пункт по названиб и кликает по нему
     *
     * @param itemName - название пункта
     */
    public void selectUiItemByText(String itemName) {
        Boolean found = false;
        for (WebElement item : uiItems()) {
            if (item.getText().equals(itemName)) {
                item.findElement(By.cssSelector(".ui-link")).click();
                found = true;
                break;
            }
        }

        String message = found ? "Выбор пункта \"" + itemName + "\""
                : "Пункт \"" + itemName + "\" не найден";

        LOGGER.info(message);
    }

    /**
     * Выбор итема по локатору
     *
     * @param locator
     */
    public void selectUiItemBy(By locator) {
        if (firstElementLocator.isEmpty()) {
            webDriver.findElement(By.cssSelector(".ui-" + predicateLocator + "__" + postfixLocator))
                    .findElement(locator).click();
        } else {
            webDriver.findElement(By.cssSelector(firstElementLocator + " .ui-" + predicateLocator + "__" + postfixLocator))
                    .findElement(locator).click();
        }
    }

    public WebElement getUiItemByText(String itemName) {
        for (WebElement item : uiItems()) {
            if (item.getText().equals(itemName)) {
                return item;
            }
        }

        LOGGER.info("Пункт \"" + itemName + "\" не найден");
        return null;
    }


    public WebElement getUiItemByIndex(Integer ind) {
        return uiItems().get(ind);
    }

    public void selectUiItemByIndex(Integer ind) {
        uiItems().get(ind).click();
        LOGGER.info("Выбор пункта №" + (ind + 1));
    }
}
