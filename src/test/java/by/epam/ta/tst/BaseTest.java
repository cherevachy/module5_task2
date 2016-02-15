package by.epam.ta.tst;

import by.epam.ta.businessobjects.Mail;
import by.epam.ta.businessobjects.User;
import by.epam.ta.runner.TestProperties;
import by.epam.ta.core.webdriver.Browser;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static final String BASE_URL = TestProperties.getInstance().getBaseUrl();

    protected WebDriver webDriver;

    protected User user;

    protected Mail mail;
    
    protected TestProperties testProperties;

    @Before
    public void setUp() {
        user = new User(TestProperties.getInstance().getUserName(), TestProperties.getInstance().getUserPassword());
        //this.webDriver = this.getWebDriver();
        webDriver = Browser.initBrowser();
        this.webDriver.get(BASE_URL);
        }

    private WebDriver getWebDriver() {
        final WebDriver webDriver = new ChromeDriver();
        webDriver.manage()
                .timeouts()
                .implicitlyWait(10L, TimeUnit.SECONDS);
        webDriver.manage()
                .timeouts()
                .pageLoadTimeout(20L, TimeUnit.SECONDS);
        return webDriver;
    }

    @After
    public void cleanUp() {
        //webDriver.quit();
    	Browser.closeDriver();
    }
}
