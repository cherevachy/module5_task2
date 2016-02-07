package by.epam.po;

import java.io.File;
import java.io.IOException;

import by.epam.model.Mail;

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

    public void highlightElement(WebDriver webDr, WebElement element){
		String defColor=element.getCssValue("backgroundColor");
		((JavascriptExecutor)webDr).executeScript("arguments[0].style.backgroundColor = '"+"green"+"'",element);
		File pic = ((TakesScreenshot)webDr).getScreenshotAs(OutputType.FILE);
		File picPath=null;
		if (webDr instanceof  FirefoxDriver) {
			picPath=new File("./highlight_firefox.png");			
		} else if (webDr instanceof  ChromeDriver) {
			picPath=new File("./highlight_chrome.png");			
		} else {
			picPath=new File("./otherBrowser.png");
		};
	    try {
	    	FileUtils.copyFile(pic, picPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		((JavascriptExecutor)webDr).executeScript("arguments[0].style.backgroundColor = '"+defColor+"'",element);
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
