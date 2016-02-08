package by.epam.ta.core.webdriver.logger;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import org.testng.Reporter;

public class TestNgReportAppender extends AppenderSkeleton {

    @Override
    protected void append(LoggingEvent event) {
        String log = this.layout.format(event);
        log = log.replaceAll("\n", "<br>\n");
        Reporter.log(log);
    }

    public void close() {
    }

    public boolean requiresLayout() {
        return true;
    }
}
