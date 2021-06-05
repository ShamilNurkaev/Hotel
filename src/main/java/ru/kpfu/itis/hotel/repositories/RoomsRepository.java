package ru.kpfu.itis.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.kpfu.itis.hotel.models.Room;

import java.util.List;
import java.util.Optional;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 2
 */

public interface RoomsRepository extends JpaRepository<Room, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM room_hotel WHERE name = :name")
    Optional<Room> findByName(String name);

    List<Room> findAllByDateToLessThan(Long dateFrom);

    @Query(nativeQuery = true, value =
            "WITH _popular_rooms AS (\n" +
            "    SELECT bh.room_id\n" +
            "    FROM booking_hotel bh\n" +
            "    GROUP BY bh.room_id\n" +
            "    HAVING bh.room_id = MAX(bh.room_id)\n" +
            ")\n" +
            "SELECT rh.id, rh.adults_number, rh.child_number, rh.date_from, rh.date_to,\n" +
            "       rh.name, rh.photo, rh.price, rh.rooms_number, rh.user_id\n" +
            "FROM room_hotel rh\n" +
            "         INNER JOIN _popular_rooms _pr ON rh.id = _pr.room_id")
    List<Room> findMostPopularRooms();

    /*@Query(nativeQuery = true, value = "SELECT * FROM room_hotel WHERE dateto < :date_from")
    List<Room> getAvailableRooms(@Param("date_from") Long dateFrom) throws NoRoomsAvailableException;*/
}
