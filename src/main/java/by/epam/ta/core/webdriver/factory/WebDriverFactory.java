package by.epam.ta.core.webdriver.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Factory for WebDriver instances
 */
public interface WebDriverFactory {
    /**
     * Creates new WebDriver instance
     * @return - WebDriver
     */
    WebDriver createWebDriver();

    /**
     * Create web driver with additional capabilities
     * @param capabilities
     * @return
     */
    WebDriver createWebDriver(DesiredCapabilities capabilities);

}

