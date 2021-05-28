package ru.kpfu.itis.hotel.exceptions;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 1
 */

public class NoRoomsAvailableException extends HotelApplicationException {
    public static final String DEFAULT_MESSAGE = "No Rooms Available Exception";

    public NoRoomsAvailableException() {
        super(DEFAULT_MESSAGE);
    }

    public NoRoomsAvailableException(String message) {
        super(message);
    }
}
