package by.epam.ta.core.webdriver;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import by.epam.ta.core.webdriver.factory.WebDriverFactoryManager;
import by.epam.ta.runner.GlobalConfiguration;

public class Browser {
	
    private static WebDriver webDriver;

    //public static WebDriver getInstance(){
        //return webDriver;
    //}

    public static WebDriver initBrowser() {
    	if (null == webDriver) {
        BrowserType browserType = GlobalConfiguration.getInstance().getBrowserType();
        WebDriverFactoryManager driverManager = new WebDriverFactoryManager(browserType);

        webDriver = driverManager.createWebDriverForBrowser(browserType);
        webDriver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // Activate Decorator - looks like the part of the steps do not pass after that
        //webDriver = new Decorator(webDriver);
    	}
        return webDriver;
    }

	public static void closeDriver() {
        webDriver.quit();
        webDriver = null;
    }
}
