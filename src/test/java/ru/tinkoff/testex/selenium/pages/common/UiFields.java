package ru.tinkoff.testex.selenium.pages.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Di on 18.11.2017.
 */
public class UiFields extends UiList {
    private static final Logger LOGGER = Logger.getLogger(UiFields.class);


    public UiFields(String predicateLocator, WebDriver webDriver) {
        super(predicateLocator, "field", webDriver);
    }

    public UiFields(String firstElementLocator, String predicateLocator, WebDriver webDriver) {
        super(firstElementLocator, predicateLocator, "field", webDriver);
    }


    @Override
    public WebElement getUiItemByText(String itemName) {
        for (WebElement item : uiItems()) {
            if (item.findElement(By.cssSelector(".ui-input__label")).getText().equals(itemName)) {
                return item;
            }
        }

        LOGGER.info("Поле \"" + itemName + "\" не найдено");

        return null;
    }

    /**
     * Метод проверяет наличие сообщения об ошибке, если есть, то возвращает текст ошибки
     *
     * @param fieldText - текст внутри поля у которого смотрим сообщение об ошибке
     * @return
     */
    public String getErrorIfExist(String fieldText) {
        WebElement field = this.getUiItemByText(fieldText);
        WebElement error = null;
        try {
            error = field.findElement(By.cssSelector(".ui-form-field-error-message"));
        } catch (NoSuchElementException ex) {
            LOGGER.error("Сообщение об ошибке отсутствует");
            ex.printStackTrace();
        }

        return error.getText();
    }

}
