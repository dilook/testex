package ru.tinkoff.testex.selenium.pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Di on 17.09.2017.
 */
public class Page {

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    public Page(){
        ChromeOptions co = new ChromeOptions()
                .addArguments("--start-maximized");
        this.webDriver = new ChromeDriver(co);
        webDriverWait = new WebDriverWait(webDriver, 10);
    }

    public Page(WebDriver webDriver){
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, 10);
    }

    public Boolean isElementPresent(By locator){
        return webDriver.findElements(locator).size() > 0;

    }
}
