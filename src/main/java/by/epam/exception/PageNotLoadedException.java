package by.epam.exception;

import org.openqa.selenium.NoSuchElementException;

public class PageNotLoadedException extends NoSuchElementException {

    public PageNotLoadedException(final String reason, final Throwable cause) {
        super(reason, cause);
    }

}
