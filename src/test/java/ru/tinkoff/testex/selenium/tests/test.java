package ru.tinkoff.testex.selenium.tests;

import org.junit.Test;

/**
 * Created by Di on 15.11.2017.
 */
public class test extends TestBase {

    @Test
    public void test() {
        app.mainPage.open();
        app.menuBar.goTo("ПЛАТЕЖИ");

    }
}
