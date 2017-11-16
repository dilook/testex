package ru.tinkoff.testex.selenium.tests;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Di on 15.11.2017.
 */
public class test extends TestBase {

    @Test
    public void test() {

        app.mainPage.open();
        app.menuBar.goTo("ПЛАТЕЖИ");
        app.uiMenu.selectUiItemByText("Коммунальные платежи");
        checkAndSelectRegion();
        String serviceName = checkAndSelectCommunalService();
        app.hcsMoscowPage.payTab.click();

    }

    private String checkAndSelectCommunalService() {
        String serviceName = app.communalPaymentsPage.getUiItemByIndex(0).getText();
        Assert.assertEquals("Ошибка ранжирования поставщиков ЖКУ", "ЖКУ-Москва", serviceName);
        app.communalPaymentsPage.selectUiItemByIndex(0);

        return serviceName;
    }

    private void checkAndSelectRegion() {
        Boolean check = app.communalPaymentsPage.isRegion("Москве");
        if(!check){
            app.communalPaymentsPage.region.click();
            app.regionsPage.selectUiItemByText("г. Москва");
        }
    }
}
