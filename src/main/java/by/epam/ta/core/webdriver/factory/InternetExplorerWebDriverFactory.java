package by.epam.ta.core.webdriver.factory;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.base.Preconditions;

/**
 * Factory implementation for Internet Explorer WebDriver
 * Created by Daniil_Novikau on 8/28/2015.
 */
public class InternetExplorerWebDriverFactory implements WebDriverFactory {

    private String ieBinaryPath = "c:\\Program Files (x86)\\Internet Explorer\\iexplore.exe";

    public InternetExplorerWebDriverFactory(String ieBinaryPath) {
        Preconditions.checkNotNull(ieBinaryPath);
        this.ieBinaryPath = ieBinaryPath;
    }

    public InternetExplorerDriver createWebDriver() {
        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
        if (StringUtils.isNotEmpty(ieBinaryPath))
            System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY, ieBinaryPath);

        return new InternetExplorerDriver(ieCapabilities);
    }

    public WebDriver createWebDriver(DesiredCapabilities capabilities) {
        DesiredCapabilities ieCapabilities = DesiredCapabilities
                .internetExplorer();
        if (StringUtils.isNotEmpty(ieBinaryPath))
            ieCapabilities.setCapability(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY, ieBinaryPath);

        return new InternetExplorerDriver(ieCapabilities.merge(capabilities));
    }

}

