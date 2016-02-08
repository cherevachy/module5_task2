package by.epam.ta.ui.pages;

import by.epam.ta.businessobjects.User;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(name="Email")
    private WebElement txbEmail;

    @FindBy(id="next")
    private WebElement btnNext;

    @FindBy(name="Passwd")
    private WebElement txbPassword;

    @FindBy(id="signIn")
    private WebElement btnSignIn;

    @FindBy(id="rsi-card")
    private WebElement signInPanel;

    public LoginPage(final WebDriver webDriver) {
        super(webDriver);
    }

    public InboxPage loginAs(final User user) {
        this.waitElement(this.txbEmail);
        this.txbEmail.sendKeys(user.getEmail());
        this.btnNext.click();
        this.txbPassword.sendKeys(user.getPassword());
        this.btnSignIn.click();
        return new InboxPage(this.webDriver);
    }

}
