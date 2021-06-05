package ru.kpfu.itis.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.hotel.models.BookingHistory;
import ru.kpfu.itis.hotel.models.Room;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * 20.05.2021
 * Hotel
 *
 * @author Shamil Nurkaev @nshamil
 * 11-903
 */

public interface BookingHistoryRepository extends JpaRepository<BookingHistory, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM booking_hotel " +
            "WHERE user_id = :user_id AND date_to > :date_from")
    List<Room> findRoomsByUser(@Param("user_id") Long userId, @Param("date_from") Date dateFrom);

    @Query(nativeQuery = true, value = "SELECT * FROM booking_hotel WHERE room_id=:room_id AND user_id=:user_id")
    Optional<BookingHistory> findByRoomIdAndUserId(@Param("room_id") Long roomId,
                                                   @Param("user_id") Long userId);


    @Query(nativeQuery = true, value = "SELECT * FROM booking_hotel WHERE user_id = :user_id")
    List<BookingHistory> findAllByUserId(@Param("user_id") Long userId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "INSERT INTO booking_hotel (date_from, date_to, room_id, user_id) " +
            "VALUES (date_from, date_to, room_id, user_id)")
    void addBooking(@Param("user_id") Long userId,
                    @Param("room_id") Long roomId,
                    @Param("date_from") Date dateFrom,
                    @Param("date_to") Date dateTo);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE booking_hotel " +
            "SET date_from = :date_from, date_to = :date_to " +
            "WHERE user_id = :user_id AND room_id = :room_id")
    BookingHistory editBooking(@Param("user_id") Long userId,
                               @Param("room_id") Long roomId,
                               @Param("date_from") Date dateFrom,
                               @Param("date_to") Date dateTo);
}
