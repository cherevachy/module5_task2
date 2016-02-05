package by.epam.po;

import by.epam.model.Mail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InboxPage extends BasePage {

    private final static String pageElementLocator = "//*[@role='button' and text()='COMPOSE']";

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
