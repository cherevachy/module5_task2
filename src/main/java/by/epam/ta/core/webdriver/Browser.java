package by.epam.ta.core.webdriver;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import by.epam.ta.core.webdriver.factory.WebDriverFactoryManager;
import by.epam.ta.runner.GlobalConfiguration;

public class Browser {

    private final static Logger logger = Logger.getLogger(Browser.class);

    private static WebDriver webDriver;

    public static WebDriver getInstance(){
        return webDriver;
    }

    public static WebDriver initBrowser() {
        BrowserType browserType = GlobalConfiguration.getInstance().getBrowserType();
        WebDriverFactoryManager driverManager = new WebDriverFactoryManager(browserType);

        webDriver = driverManager.createWedDriverForBrowser(browserType);
        webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        logger.info("Browser started");
		return webDriver;
    }

    public static void closeDriver() {
        webDriver.quit();
        logger.info("Browser closed");
    }
}
