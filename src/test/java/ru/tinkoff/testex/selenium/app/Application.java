package ru.tinkoff.testex.selenium.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.tinkoff.testex.selenium.pages.*;
import ru.tinkoff.testex.selenium.pages.common.Loader;
import ru.tinkoff.testex.selenium.pages.common.UiMenu;

import static ru.tinkoff.testex.selenium.WebDriverTestUtils.selectWebDriver;

/**
 * Created by Di on 17.09.2017.
 */
public class Application{

    private WebDriver webDriver;

    public MainPage mainPage;
    public MenuBar menuBar;
    public CommunalPaymentsPage communalPaymentsPage;
    public RegionsPage regionsPage;
    public UiMenu uiMenu;
    public Loader loader;
    public HCSMoscowPage hcsMoscowPage;

    public Application() {
        DesiredCapabilities caps = new DesiredCapabilities();
        webDriver = selectWebDriver(caps);
        mainPage = new MainPage(webDriver);
        menuBar = new MenuBar(webDriver);
        communalPaymentsPage = new CommunalPaymentsPage(webDriver);
        regionsPage = new RegionsPage(webDriver);
        uiMenu = new UiMenu(webDriver);
        loader = new Loader();
        hcsMoscowPage = new HCSMoscowPage(webDriver);
    }

    public void quit() {
        webDriver.quit();
    }
}
