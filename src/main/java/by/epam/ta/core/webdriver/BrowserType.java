package by.epam.ta.core.webdriver;

import com.google.common.base.Joiner;
import org.apache.log4j.Logger;

public enum BrowserType {

    FIREFOX, CHROME, IE;

    public static BrowserType byName(String name) {
        if ((name == null) || (name.isEmpty()))
            return null;

        try {
            return BrowserType.valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
        	System.out.println("Unknown browser type: '" + name + "'. Please, use one of " + Joiner.on('\n').join(BrowserType.values())
                    + " values");
            return null;
        }
    }

    @Override
    public String toString() {
        return name();
    }

}

