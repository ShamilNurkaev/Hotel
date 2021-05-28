package ru.kpfu.itis.hotel.exceptions;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 2
 */

public class DuplicateEntryException extends HotelApplicationException {

    public static final String DEFAULT_MESSAGE = "Duplicate Entry Exception";

    public DuplicateEntryException() {
        super(DEFAULT_MESSAGE);
    }

    public DuplicateEntryException(String message) {
        super(message);
    }
}
