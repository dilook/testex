package ru.tinkoff.testex.selenium;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.*;
import java.util.Properties;

import static org.openqa.selenium.Proxy.ProxyType.AUTODETECT;

/**
 * Created by Di on 24.08.2017.
 */
public class WebDriverTestUtils {
    public static final String url = extractPath("src/test/resources/app.properties", "app.url");

    /**
     * Выбор вебдрайвера в зависимости от значения параметра jvm -Dbrowser
     * FF - firefox
     * IE - Intrenet Explorer
     * CR - Chrome
     * По умолчанию значение Chrome
     *
     * @param caps
     * @return
     */
    public static WebDriver selectWebDriver(DesiredCapabilities caps) {
        String browser = System.getProperty("browser", "CR");
        System.out.println(browser);

        switch (browser) {
            case "FF":
                FirefoxOptions fo = new FirefoxOptions()
                        .setLegacy(false)
                        .setBinary(extractPath("src/test/resources/caps.properties", "ff.path"));
                caps.setCapability(CapabilityType.PROXY, setProxy());
                caps.setCapability(FirefoxOptions.FIREFOX_OPTIONS, fo);
                return new FirefoxDriver(caps);

            case "IE":
                caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                WebDriver ieDriver = new InternetExplorerDriver(caps);
                ieDriver.manage().window().maximize();
                return ieDriver;

            case "CR":
                return caps == null ? new ChromeDriver() : new ChromeDriver(caps);

            default:
                return caps == null ? new ChromeDriver() : new ChromeDriver(caps);
        }

    }

    /**
     * Метод вычитывает проперти из файла
     * @param propFilePath
     * @param propName
     * @return
     */
    public static String extractPath(String propFilePath, String propName) {
        Properties properties = new Properties();

        try (FileInputStream fis = new FileInputStream(propFilePath)) {
            properties.load(fis);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return properties.getProperty(propName);
    }

    private static Proxy setProxy() {
        Proxy proxy = new Proxy();
        proxy.setProxyType(AUTODETECT);

        return proxy;
    }


}
