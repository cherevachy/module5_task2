package by.epam.ta.core.webdriver.listener;

import by.epam.ta.core.webdriver.Browser;
import by.epam.ta.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import org.apache.log4j.Logger;

public class MakingScreenshotsOnErrorListener extends TestListenerAdapter {

    private final static Logger LOGGER = Logger.getLogger(MakingScreenshotsOnErrorListener.class);
    private static final String RP_MESSAGE = "RP_MESSAGE#FILE#%1$s#%2$s";

    @Override
    public void onTestFailure(ITestResult testResult) {
        //WebDriver browser = Browser.getInstance();
    	WebDriver browser = Browser.initBrowser();
        if ( null != browser ) {
            try {
                File srcFile = ScreenshotUtils.makeScreenshot(browser);
                String errorMsg = String.format(RP_MESSAGE, srcFile.getCanonicalPath(), " WebDriver screenshot captured: " + srcFile.getName());
                // uncomment the next line in order to attach file to report portal log
//              LOGGER.info(errorMsg);
            } catch (IOException ex){
                LOGGER.error("Error while logging screen-shot to RP.");
            }
        }
    }
}
