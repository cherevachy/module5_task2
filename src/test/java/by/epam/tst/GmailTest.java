package by.epam.tst;

import by.epam.exception.PageNotLoadedException;
import by.epam.model.Mail;
import by.epam.po.DraftsPage;
import by.epam.po.InboxPage;
import by.epam.po.LoginPage;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertTrue;

public class GmailTest extends BaseTest {

    @Test
    public void test01LoginAsValidUser() {
        final String text = "ivanovtestbox@gmail.com - Gmail";
        final LoginPage loginPage = new LoginPage(webDriver);
        final InboxPage inboxPage = loginPage.loginAs(user);
        final String actualPageTitle = inboxPage.getPageTitle();
        assertTrue("User is logged into gmail inbox correctly", actualPageTitle.contains(text));
    }

    @Test(expected = PageNotLoadedException.class)
    public void test02LoginAsInvalidUser() {
        user.setPassword("123456!23aAQE");
        final LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loginAs(user);
    }

    @Test
    public void test03SendMail() {
        mail = new Mail("ivanovtestbox@gmail.com", "tam1test1" + new Date(), "Hello, Yuri!" + new Date());
        final LoginPage loginPage = new LoginPage(webDriver);
        final InboxPage inboxPage = loginPage.loginAs(user);
        inboxPage.createEmail(mail).sendEmail().highlightElement(webDriver, inboxPage.getSuccessMsg());
        assertTrue("Mail was sent correctly", inboxPage.elementExists(inboxPage.getSuccessMsg()));
    }

}
