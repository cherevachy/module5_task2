package by.epam.ta.core.webdriver.exception;

/**
 *  Created by Daniil_Novikau on 9/15/2015.
 */
public class ItemNotFoundException extends RuntimeException
{
    private static final long serialVersionUID = 8470378839209537048L;

    public ItemNotFoundException(String errorMessage) {
        super( errorMessage );
    }

    public ItemNotFoundException(String message, Throwable cause) {
        super( message, cause );
    }
}
