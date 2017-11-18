package ru.tinkoff.testex.selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.Proxy.ProxyType.AUTODETECT;

/**
 * Created by Di on 24.08.2017.
 */
public class WebDriverTestUtils {
    public static final String baseUrl = extractPath("src/test/resources/app.properties", "app.url");
    private static final Long implWait = Long.parseLong(extractPath("src/test/resources/app.properties", "driver.implWait"));
    private static final Logger LOGGER = Logger.getLogger(WebDriverTestUtils.class);

    /**
     * Выбор вебдрайвера в зависимости от значения параметра jvm -Dbrowser
     * FF - Firefox
     * IE - Internet Explorer
     * CR - Chrome
     * По умолчанию значение Chrome
     *
     * @param caps
     * @return
     */
    public static WebDriver selectWebDriver(DesiredCapabilities caps) {
        String browser = System.getProperty("browser", "CR");
        System.out.println(browser);

        WebDriver driver = null;

        switch (browser) {
            case "FF":
                FirefoxOptions fo = new FirefoxOptions()
                        .setLegacy(false)
                        .setBinary(extractPath("src/test/resources/caps.properties", "ff.path"));
                caps.setCapability(CapabilityType.PROXY, setProxy());
                caps.setCapability(FirefoxOptions.FIREFOX_OPTIONS, fo);
                driver = new FirefoxDriver(caps);
                break;

            case "IE":
                caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                driver = new InternetExplorerDriver(caps);
                driver.manage().window().maximize();
                break;

            case "CR":
                ChromeOptions co = new ChromeOptions()
                        .addArguments("--start-maximized");
                caps.setCapability(ChromeOptions.CAPABILITY, co);
                driver = new ChromeDriver(caps);
        }

        try {
            driver.manage().timeouts().implicitlyWait(implWait, TimeUnit.MILLISECONDS);
        } catch (NullPointerException ex) {
            LOGGER.error("Driver wasn't initialized");
        }

        return driver;

    }

    /**
     * Метод вычитывает проперти из файла
     *
     * @param propFilePath - путь до свойства
     * @param propName     - название свойства
     * @return
     */
    public static String extractPath(String propFilePath, String propName) {
        Properties properties = new Properties();

        try (FileInputStream fis = new FileInputStream(propFilePath)) {
            properties.load(fis);
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
