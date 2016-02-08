package by.epam.ta.ui.pages;

import by.epam.ta.core.webdriver.exception.PageNotLoadedException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected final WebDriver webDriver;

    public BasePage(final WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public BasePage(final WebDriver webDriver, final String xpathElementLocator) {
        this(webDriver);

        try {
            waitElement(webDriver.findElement(By.xpath(xpathElementLocator)));
        } catch (final NoSuchElementException ex) {
            final String errorMsg = "\n****** " + this.getClass().getSimpleName() + " is not loaded ***** \n";
            throw new PageNotLoadedException(errorMsg, ex);
        }
    }

    public String getPageTitle() {
        return this.webDriver.getTitle();
    }

    public void waitElement(final WebElement element) throws NoSuchElementException {
        (new WebDriverWait(this.webDriver, 20))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public boolean elementExists(final WebElement webElement) {
        return webElement.isDisplayed();
    }

}
