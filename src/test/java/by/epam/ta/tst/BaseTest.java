package by.epam.ta.tst;

import by.epam.ta.businessobjects.Mail;
import by.epam.ta.businessobjects.User;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static final String BASE_URL = "http://gmail.com";

    protected WebDriver webDriver;

    protected User user;

    protected Mail mail;

    @Before
    public void setUp() {
        user = new User("ivanovtestbox@gmail.com", "AuroraBorealis2015%");
        this.webDriver = this.getWebDriver();
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
        webDriver.quit();
    }
}
