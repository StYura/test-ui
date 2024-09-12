package org.table.test_task_ui;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.SneakyThrows;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.Properties;

public class BaseTest {
    public static ThreadLocal<Properties> configuration = new ThreadLocal<>();

    @BeforeSuite
    public void beforeSuite() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .includeSelenideSteps(false)
                        .savePageSource(true));
    }

    @BeforeTest
    @SneakyThrows
    @Parameters({"env"})
    public void beforeTest(@Optional("dev") String env) {
        Properties properties = new Properties();
        properties
                .load(Thread.currentThread()
                        .getContextClassLoader()
                        .getResourceAsStream(env));
        configuration.set(properties);
    }

    protected static String getUrl() {
        return configuration.get().getProperty("url");
    }
}
