package ru.kpfu.itis.hotel.services;


import ru.kpfu.itis.hotel.dto.AvailabilityDto;
import ru.kpfu.itis.hotel.exceptions.NoRoomsAvailableException;
import ru.kpfu.itis.hotel.models.Room;

import java.util.List;
import java.util.Optional;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 2
 */

public interface RoomsService {
    void save(Room entity);
    void delete(Room entity);
//    void update(Room entity);
    Optional<Room> findById(Long id);
    Optional<Room> findByName(String name);
    List<Room> getAllRooms();
    List<Room> getAvailableRooms(AvailabilityDto availabilityDto) throws NoRoomsAvailableException;
}
