package ru.tinkoff.testex.selenium.tests;

import org.junit.Before;
import ru.tinkoff.testex.selenium.app.Application;

/**
 * Created by Di on 17.09.2017.
 */
public class TestBase {
    public static ThreadLocal<Application> tlApp = new ThreadLocal<>();
    public Application app;

    @Before
    public void start() {
        if (tlApp.get() != null) {
            app = tlApp.get();
            return;
        }

        app = new Application();
        tlApp.set(app);

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {
                    app.quit();
                    app = null;
                }));
    }

}
