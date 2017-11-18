package ru.tinkoff.testex.selenium.tests;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;

import java.util.Random;

/**
 * Created by Di on 15.11.2017.
 */
public class test extends TestBase {
    private static final Logger LOGGER = Logger.getLogger(test.class);

    @Test
    public void test() {
        app.mainPage.open();
        app.menuBar.goTo("ПЛАТЕЖИ");
        app.uiMenu.selectUiItemByText("Коммунальные платежи");
        checkAndSelectRegion();
        String serviceName = checkAndSelectCommunalService();
        app.hcsMoscowPage.payTab().click();
        checksPayerCodeField();
    }

    private void checksPayerCodeField() {
        String errorText = "Поле неправильно заполнено";
        String value;
        for (int i = 1; i < 10; i++) {
            value = getRand(i);
            app.hcsMoscowPage.providerPayerCode().clear();
            app.hcsMoscowPage.providerPayerCode().sendKeys(value);
            app.hcsMoscowPage.providerPayerCode().sendKeys(Keys.TAB);
            LOGGER.info("Ввод значения \"" + value + "\" в поле");

            LOGGER.info("Проверка наличия ошибки \"" + errorText + "\"");
            Assert.assertEquals("Сообщение неверно", errorText,
                    app.hcsMoscowPage.getErrorIfExist("Код плательщика за ЖКУ в Москве"));
        }

        LOGGER.info("Проверка ввода некорректных символов");
        app.hcsMoscowPage.providerPayerCode().clear();
        app.hcsMoscowPage.providerPayerCode().sendKeys("WEQEwety@#$%^&*  (");
        Assert.assertEquals("В поле присутствуют недопустимые символы", "",
                app.hcsMoscowPage.providerPayerCode().getAttribute("value"));

        app.hcsMoscowPage.providerPayerCode().clear();
        app.hcsMoscowPage.providerPayerCode().sendKeys(Keys.ENTER);
        Assert.assertEquals("Сообщение неверно", "Поле обязательное",
                app.hcsMoscowPage.getErrorIfExist("Код плательщика за ЖКУ в Москве"));
    }

    private String getRand(int len) {
        String digit = "0123456789";
        Random rnd = new Random(47);

        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(digit.charAt(rnd.nextInt(digit.length())));

        return sb.toString();
    }


    private String checkAndSelectCommunalService() {
        String serviceName = app.communalPaymentsPage.getUiItemByIndex(0).getText();
        Assert.assertEquals("Ошибка ранжирования поставщиков ЖКУ", "ЖКУ-Москва", serviceName);
        app.communalPaymentsPage.selectUiItemByIndex(0);

        return serviceName;
    }

    private void checkAndSelectRegion() {
        String txt = app.communalPaymentsPage.region().getText();
        Boolean check = txt.equals("Москве");
        LOGGER.debug(txt);
        if (!check) {
            app.communalPaymentsPage.region().click();
            app.regionsPage.selectUiItemByText("г. Москва");
        }
    }
}
