package by.epam.ta.tst;

import by.epam.ta.businessobjects.Mail;
import by.epam.ta.core.webdriver.exception.PageNotLoadedException;
import by.epam.ta.ui.pages.DraftsPage;
import by.epam.ta.ui.pages.InboxPage;
import by.epam.ta.ui.pages.LoginPage;
import by.epam.ta.utils.HighlightUtils;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertTrue;

public class GmailTest extends BaseTest {

    @Test
    public void test01LoginAsValidUser() {
        final String text = "ivanovtestbox@gmail.com - Gmail";
        final LoginPage loginPage = new LoginPage(webDriver).signIn();
        final InboxPage inboxPage = loginPage.loginAs(user);
        final String actualPageTitle = inboxPage.getPageTitle();
        assertTrue("User is logged into gmail inbox correctly", actualPageTitle.contains(text));
        inboxPage.signOut();
    }

    @Test(expected = PageNotLoadedException.class)
    public void test02LoginAsInvalidUser() {
        user.setPassword("123456!23aAQE");
        final LoginPage loginPage = new LoginPage(webDriver).signIn();
        loginPage.loginAs(user);
    }

    @Test
    public void test03SendMail() {
        mail = new Mail("ivanovtestbox@gmail.com", "tam1test1" + new Date(), "Hello, Yuri!" + new Date());
        final HighlightUtils highlight = new HighlightUtils();
        final LoginPage loginPage = new LoginPage(webDriver);
        final InboxPage inboxPage = loginPage.loginAs(user);
        inboxPage.createEmail(mail).sendEmail();
        highlight.highlightElement(webDriver, inboxPage.getSuccessMsg());
        assertTrue("Mail was sent correctly", inboxPage.elementExists(inboxPage.getSuccessMsg()));
        inboxPage.signOut();
    }

}
