package ru.tinkoff.testex.selenium.pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by Di on 16.11.2017.
 */
public class UiList extends Page {
    private String predicateLocator;

    public UiList(String predicateLocator, WebDriver webDriver) {
        super(webDriver);
        this.predicateLocator = predicateLocator;
    }

    public List<WebElement> uiItems() {
        webDriverWait.until(visibilityOfElementLocated(By.cssSelector(".ui-" + predicateLocator)));
        return webDriver.findElements(By.cssSelector(".ui-" + predicateLocator + "__item"));
    }

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

        System.out.println(message);
    }

    public WebElement getUiItemByIndex(Integer ind) {
        return uiItems().get(ind);
    }

    public void selectUiItemByIndex(Integer ind) {
        uiItems().get(ind).click();
        System.out.println("Выбор пункта №" + (ind + 1));
    }
}
