package ru.kpfu.itis.hotel.controllers;

/**
 * 20.05.2021
 * Hotel
 *
 * @author Shamil Nurkaev @nshamil
 * 11-903
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.hotel.models.BookingHistory;
import ru.kpfu.itis.hotel.models.Room;
import ru.kpfu.itis.hotel.models.User;
import ru.kpfu.itis.hotel.services.BookingHistoryService;
import ru.kpfu.itis.hotel.services.RoomsService;
import ru.kpfu.itis.hotel.services.UsersService;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServlet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 1
 */

@Controller
public class BookingController extends HttpServlet {

    private final UsersService usersService;
    private final RoomsService roomsService;
    private final BookingHistoryService bookingService;

    @Autowired
    public BookingController(UsersService usersService,
                             RoomsService roomsService,
                             BookingHistoryService bookingService) {
        this.usersService = usersService;
        this.roomsService = roomsService;
        this.bookingService = bookingService;
    }

    @PermitAll
    @PostMapping("/booking")
    public String bookingRoom(@AuthenticationPrincipal UserDetails userDetails,
                              @RequestParam("id") Long roomId) {
        Optional<User> userOptional = usersService.findOneByEmail(userDetails.getUsername());
        Optional<Room> roomOptional = roomsService.findById(roomId);

        if (userOptional.isPresent() && roomOptional.isPresent()) {
            User user = userOptional.get();
            Room room = roomOptional.get();
            /*System.out.println("room = " + room);
            System.out.println("user = " + user);
            Optional<BookingHistory> bookingHistoryOptional = bookingRepository
                    .findByRoomIdAndUserId(roomId, user.getId());
            System.out.println("bookingHistoryOptional = " + bookingHistoryOptional);
            if (!bookingHistoryOptional.isPresent()) {*/
            BookingHistory newBooking = BookingHistory.builder()
                    .user(user)
                    .room(room)
                    .dateFrom(Timestamp.valueOf((LocalDateTime.now())))
                    .dateTo(Timestamp.valueOf(LocalDateTime.now().plusDays(10)))
                    .build();
            bookingService.save(newBooking);
            /*}*/
        }

        return "redirect:/main";
    }
}
