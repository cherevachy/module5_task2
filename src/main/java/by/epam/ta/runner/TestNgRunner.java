package by.epam.ta.runner;

import by.epam.ta.core.webdriver.listener.MakingScreenshotsOnErrorListener;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;
import java.util.List;

public class TestNgRunner {

    /**
     * Executes TestNG tests
     * @param args - additional test parameters
     */
    public static void main(String[] args) {

        TestListenerAdapter tla = new MakingScreenshotsOnErrorListener();
        TestNG testng = new TestNG();
        testng.addListener(tla);

        try {
            List<XmlSuite> suite = (List <XmlSuite>) (new Parser(args[0]).parse());
            testng.setXmlSuites(suite);
            testng.run();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
