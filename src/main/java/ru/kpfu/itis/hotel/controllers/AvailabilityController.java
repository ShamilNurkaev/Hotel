package ru.kpfu.itis.hotel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.hotel.dto.AvailabilityDto;
import ru.kpfu.itis.hotel.exceptions.NoRoomsAvailableException;
import ru.kpfu.itis.hotel.models.Room;
import ru.kpfu.itis.hotel.services.RoomsService;

import javax.annotation.security.PermitAll;
import java.util.List;

/**
 * 10.02.2021
 * 06.Hotel
 *
 * @author Shamil Nurkaev @nshamil
 * 11-903
 */

@Controller
public class AvailabilityController {

    private final RoomsService roomsService;

    @Autowired
    public AvailabilityController(RoomsService roomsService) {
        this.roomsService = roomsService;
    }

    @GetMapping("/availability")
    @PermitAll
    public String getAvailabilityPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        model.addAttribute("isAuthenticated", userDetails != null);
        return "availability";
    }

    @PostMapping("/availability")
    @PermitAll
    public @ResponseBody
    List<Room> getAvailableRooms(@RequestBody AvailabilityDto availabilityDto, Model model) {
        try {
            return roomsService.getAvailableRooms(availabilityDto);
        } catch (NoRoomsAvailableException e) {
            model.addAttribute("noAvailableRooms",
                    "Нет доступных номеров с указанными параметрами. " +
                            "Вы можете выбрать номер самостоятельно среди всех.");
            return roomsService.getAllRooms();
        }
    }

    @PostMapping("/availability/popular")
    @PermitAll
    public @ResponseBody
    List<Room> getMostPopularRooms(Model model) {
        System.out.print("getMostPopularRooms controller");
        List<Room> mostPopularRooms = roomsService.findMostPopularRooms();
        System.out.println("mostPopularRooms = " + mostPopularRooms);

        return mostPopularRooms;
    }
}
