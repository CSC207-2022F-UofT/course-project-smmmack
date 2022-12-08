package Exceptions;

/**
 * WrongCommandArgumentException is an Exception that will only be thrown when the player put in wrong input argument.
 */
public class WrongCommandArgumentException extends Exception {

    public WrongCommandArgumentException(String message) {
        super(message);
    }

}
