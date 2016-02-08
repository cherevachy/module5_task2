package by.epam.ta.core.webdriver.factory;

import by.epam.ta.core.webdriver.BrowserType;
import by.epam.ta.core.webdriver.exception.ItemNotFoundException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class WebDriverFactoryManager {

    private final static Logger logger = Logger.getLogger(WebDriverFactoryManager.class);

    private String baseBinariesPath = "src\\main\\resources\\wd_binaries\\";
    private String ieBinary = baseBinariesPath + "ie\\IEDriverServer_x32_2.44.0.exe";
    private String chromeBinary = baseBinariesPath + "chrome\\chromedriver_x32_2.15.exe";

    private static BrowserType defaultBrowserType = BrowserType.FIREFOX;

    public static BrowserType getDefaultBrowserType() {
        return defaultBrowserType;
    }

    public WebDriverFactoryManager() {
    }

    public WebDriverFactoryManager(BrowserType browserType) {
        defaultBrowserType = browserType;
    }

    public WebDriver createWedDriverForBrowser() {
        return createWedDriverForBrowser(defaultBrowserType);
    }

    public WebDriver createWedDriverForBrowser(BrowserType browserType) {
        logger.info("Creating WebDriver instance by Type: '" + browserType + "'");
        WebDriverFactory result;
        switch (browserType) {
            case FIREFOX:
                result = new FirefoxWebDriverFactory();
                break;
            case IE:
                // TODO clear ie browser cache
                if (ieBinary == null) {
                    throw new ItemNotFoundException("Please set ieBinary using setIeBinary method");
                }
                result = new InternetExplorerWebDriverFactory(ieBinary);
                break;
            case CHROME:
                if (chromeBinary == null) {
                    throw new ItemNotFoundException("Please set ieBinary using setChromeBinary method");
                }
                result = new ChromeWebDriverFactory(chromeBinary);
                break;
            default:
                throw new ItemNotFoundException("There is no WebDriverFactory implementation for '"
                        + browserType.name() + "'");
        }
        return result.createWebDriver();
    }

}

