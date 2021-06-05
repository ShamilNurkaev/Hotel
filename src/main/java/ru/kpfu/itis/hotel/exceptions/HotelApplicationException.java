package ru.kpfu.itis.hotel.exceptions;

/**
 * 20.05.2021
 * Hotel
 *
 * @author Shamil Nurkaev @nshamil
 * 11-903
 */

public class HotelApplicationException extends RuntimeException {
    public HotelApplicationException(String message) {
        super(message);
    }
}
