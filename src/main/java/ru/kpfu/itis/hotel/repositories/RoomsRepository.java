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

    /*@Query(nativeQuery = true, value = "SELECT * FROM room_hotel WHERE dateto < :date_from")
    List<Room> getAvailableRooms(@Param("date_from") Long dateFrom) throws NoRoomsAvailableException;*/
}
