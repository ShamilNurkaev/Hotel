package ru.kpfu.itis.hotel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.hotel.models.BookingHistory;
import ru.kpfu.itis.hotel.models.Room;
import ru.kpfu.itis.hotel.repositories.BookingHistoryRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * 26.05.2021
 * Hotel
 *
 * @author Shamil Nurkaev @nshamil
 * 11-903
 */

@Service("bookingHistoryService")
public class BookingHistoryServiceImpl implements BookingHistoryService {

    private final BookingHistoryRepository bookingRepository;

    @Autowired
    public BookingHistoryServiceImpl(BookingHistoryRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void save(BookingHistory entity) {
        this.bookingRepository.save(entity);
    }

    @Override
    public void delete(BookingHistory entity) {
        this.bookingRepository.delete(entity);
    }

    @Override
    public List<BookingHistory> getAllBookingHistory() {
        return this.bookingRepository.findAll();
    }

    @Override
    public List<Room> findRoomsByUser(Long userId, Date dateFrom) {
        return this.bookingRepository.findRoomsByUser(userId, dateFrom);
    }

    @Override
    public Optional<BookingHistory> findByRoomIdAndUserId(Long roomId, Long userId) {
        return this.bookingRepository.findByRoomIdAndUserId(roomId, userId);
    }

    @Override
    public List<BookingHistory> findAllByUserId(Long userId) {
        return this.bookingRepository.findAllByUserId(userId);
    }

    @Override
    public void addBooking(Long userId, Long roomId, Date dateFrom, Date dateTo) {
        this.bookingRepository.addBooking(userId, roomId, dateFrom, dateTo);
    }

    @Override
    public BookingHistory editBooking(Long userId, Long roomId, Date dateFrom, Date dateTo) {
        return this.bookingRepository.editBooking(userId, roomId, dateFrom, dateTo);
    }

    @Override
    public void deleteById(Long bookingId) {
        this.bookingRepository.deleteById(bookingId);
    }
}
