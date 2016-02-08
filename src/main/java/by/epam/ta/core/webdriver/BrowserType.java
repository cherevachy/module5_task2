package by.epam.ta.core.webdriver;

import com.google.common.base.Joiner;
import org.apache.log4j.Logger;

public enum BrowserType {

    FIREFOX, CHROME, IE;

    private final static Logger LOGGER = Logger.getLogger(BrowserType.class);

    public static BrowserType byName(String name) {
        if ((name == null) || (name.isEmpty()))
            return null;

        try {
            return BrowserType.valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            LOGGER.warn("Unknown browser type: '" + name + "'. Please, use one of " + Joiner.on('\n').join(BrowserType.values())
                    + " values");
            return null;
        }
    }

    @Override
    public String toString() {
        return name();
    }

}

