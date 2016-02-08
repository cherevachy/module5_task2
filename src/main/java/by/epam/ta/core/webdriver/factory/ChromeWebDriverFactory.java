package by.epam.ta.core.webdriver.factory;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.base.Preconditions;

/**
 * Factory implementation for Chrome WebDriver
 * Created by Daniil_Novikau on 8/28/2015.
 */
public class ChromeWebDriverFactory implements WebDriverFactory {

    private String pathToBinary;

    public ChromeWebDriverFactory(String pathToBinary) {
        Preconditions.checkNotNull(pathToBinary);
        this.pathToBinary = pathToBinary;
    }

    public synchronized ChromeDriver createWebDriver() {
        DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, pathToBinary);
        return new ChromeDriver(chromeCapabilities);
    }

    public synchronized ChromeDriver createWebDriver(DesiredCapabilities extraCapabilities) {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, pathToBinary);
        return new ChromeDriver(DesiredCapabilities.chrome().merge(extraCapabilities));
    }
}

