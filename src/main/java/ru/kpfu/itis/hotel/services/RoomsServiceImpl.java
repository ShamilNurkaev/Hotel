package ru.kpfu.itis.hotel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.hotel.dto.AvailabilityDto;
import ru.kpfu.itis.hotel.exceptions.NoRoomsAvailableException;
import ru.kpfu.itis.hotel.models.Room;
import ru.kpfu.itis.hotel.repositories.RoomsRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 2
 */

@Service(value = "roomsService")
public class RoomsServiceImpl implements RoomsService {
    private final RoomsRepository roomsRepository;

    @Autowired
    public RoomsServiceImpl(RoomsRepository roomsRepository) {
        this.roomsRepository = roomsRepository;
    }

    @Override
    public void save(Room entity) {
        roomsRepository.save(entity);
    }

    @Override
    public void delete(Room entity) {
        roomsRepository.delete(entity);
    }

    /*@Override
    public void update(Room entity) {
        roomsRepository.update(entity);
    }*/

    @Override
    public Optional<Room> findById(Long id) {
        return roomsRepository.findById(id);
    }

    @Override
    public Optional<Room> findByName(String name) {
        return roomsRepository.findByName(name);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomsRepository.findAll();
    }

    @Override
    public List<Room> getAvailableRooms(AvailabilityDto availabilityDto) throws NoRoomsAvailableException {
        System.out.println(availabilityDto);
        System.out.println(roomsRepository.findAllByDateToLessThan(availabilityDto.getDateFrom()));
        return roomsRepository.findAllByDateToLessThan(availabilityDto.getDateFrom());
        // return roomsRepository.getAvailableRooms(availabilityDto.getDateFrom());
    }

    @Override
    public List<Room> findMostPopularRooms() {
        return this.roomsRepository.findMostPopularRooms();
    }
}
