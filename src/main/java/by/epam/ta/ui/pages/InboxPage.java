package by.epam.ta.ui.pages;

import java.io.File;
import java.io.IOException;

import by.epam.ta.businessobjects.Mail;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

public class InboxPage extends BasePage {

    private final static String pageElementLocator = "//*[@role='button' and text()='COMPOSE']";

    @FindBy(xpath="//*[contains(@title,'ivanovtestbox@gmail.com')]")
    private WebElement signOutMenu;
    
    @FindBy(xpath="//*[text()='Sign out']")
    private WebElement signOutBtn;
    
    @FindBy(xpath="//*[@role='button' and text()='COMPOSE']")
    private WebElement composeButton;

    @FindBy(xpath="//*[@role='dialog']")
    private WebElement composeEmail;

    @FindBy(name="to")
    private WebElement txbAddress;

    @FindBy(name="subjectbox")
    private WebElement subjectField;

    @FindBy(xpath="//div[@aria-label='Message Body']")
    private WebElement bodyField;

    @FindBy(xpath="//*[text()='Send']")
    private WebElement sendButton;

    @FindBy(xpath="//*[contains(text(), 'Your message has been sent.')]")
    private WebElement successMsg;

    public InboxPage signOut() {
        this.signOutMenu.click();
        this.signOutBtn.click();
        return this;
    }
    
    public InboxPage(final WebDriver webDriver) {
        super(webDriver, pageElementLocator);
    }

    public InboxPage createEmail(final Mail mail) {
        this.composeButton.click();
        this.txbAddress.sendKeys(mail.getTo());
        this.subjectField.sendKeys(mail.getSubject());
        this.bodyField.sendKeys(mail.getBody());
        return this;
    }
    
    public InboxPage sendEmail() {
        this.sendButton.click();
        return this;
    }

    public InboxPage saveEmailInDraft() {
        return this;
    }

    public WebElement getSuccessMsg() {
        return successMsg;
    }

}
