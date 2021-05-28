package ru.kpfu.itis.hotel.exceptions;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 2
 */

public class WrongEmailOrPasswordException extends HotelApplicationException {
    public static final String DEFAULT_MESSAGE = "Wrong Email Or Password Exception";

    public WrongEmailOrPasswordException() {
        super(DEFAULT_MESSAGE);
    }

    public WrongEmailOrPasswordException(String message) {
        super(message);
    }
}
