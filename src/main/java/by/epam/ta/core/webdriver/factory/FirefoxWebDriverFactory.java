package by.epam.ta.core.webdriver.factory;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import by.epam.ta.runner.GlobalConfiguration;

/**
 * Factory implementation for Firefox WebDriver
 * Created by Daniil_Novikau on 8/28/2015.
 */
public class FirefoxWebDriverFactory implements WebDriverFactory {

    /**
     * Path to Mozilla Firefox profile
     */
    private FirefoxProfile firefoxProfile;

    /**
     * Path to Mozilla Firefox binary file
     */
    private FirefoxBinary firefoxBinary;

    /**
     * Creates FirefoxDriver using profile
     * @param profile - prepared Firefox profile (Java representation)
     */
    public FirefoxWebDriverFactory(FirefoxProfile profile) {
        this.firefoxProfile = profile;
    }

    /**
     * Creates default FirefoxDriver
     */
    public FirefoxWebDriverFactory() {
        this.firefoxProfile = generateDefaultProfile();
        this.firefoxProfile.setEnableNativeEvents(true);
        this.firefoxProfile.setAssumeUntrustedCertificateIssuer(false);
    }

    /*
     * (non-Javadoc)
     * createWebDriver()
     */
    public synchronized FirefoxDriver createWebDriver() {
        FirefoxDriver firefoxWebDriver = new FirefoxDriver(firefoxBinary,
                firefoxProfile);
        ((RemoteWebDriver) firefoxWebDriver).setLogLevel(Level.ALL);
        return firefoxWebDriver;
    }

    public synchronized FirefoxDriver createWebDriver(DesiredCapabilities capabilities) {
        FirefoxDriver firefoxWebDriver = new FirefoxDriver(firefoxBinary,
                firefoxProfile, capabilities);
        ((RemoteWebDriver) firefoxWebDriver).setLogLevel(Level.ALL);
        return firefoxWebDriver;
    }

    private FirefoxProfile generateDefaultProfile() {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("browser.download.folderList", 2);
        firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
        firefoxProfile.setPreference("browser.download.dir", GlobalConfiguration.getInstance().getDownloadsDir());
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", StringUtils.join(MIME_TYPES, ','));
        firefoxProfile.setPreference("pdfjs.disabled", true);

        return firefoxProfile;
    }

    private static final Set<String> MIME_TYPES = new HashSet<String>() {

        private static final long serialVersionUID = 4007757631290226897L;
        {
            add("application/pdf");
            add("image/png");
            add("image/jpeg");
            //Excel format
            add("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            // TODO CIDM-1940 workaround
            // add("\"image/svg+xml\"");
            add("text/csv");
        }
    };

}

