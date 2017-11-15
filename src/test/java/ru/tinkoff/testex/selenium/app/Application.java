package ru.tinkoff.testex.selenium.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.tinkoff.testex.selenium.pages.MainPage;
import ru.tinkoff.testex.selenium.pages.MenuBar;

import static ru.tinkoff.testex.selenium.WebDriverTestUtils.selectWebDriver;

/**
 * Created by Di on 17.09.2017.
 */
public class Application {

    private WebDriver webDriver;

    public MainPage mainPage;
    public MenuBar menuBar;

    public Application() {
        DesiredCapabilities caps = new DesiredCapabilities();
        webDriver = selectWebDriver(caps);
        mainPage = new MainPage(webDriver);
        menuBar = new MenuBar(webDriver);
    }

    public void quit() {
        webDriver.quit();
    }
}
