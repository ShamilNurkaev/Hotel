package ru.kpfu.itis.hotel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.hotel.models.BookingHistory;
import ru.kpfu.itis.hotel.services.BookingHistoryService;

import java.util.List;

@RestController
public class BookingRestController {
    private final BookingHistoryService bookingService;

    @Autowired
    public BookingRestController(BookingHistoryService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/booking/{user-id}")
    public ResponseEntity<List<BookingHistory>> getBookingRooms(@PathVariable("user-id") Long userId) {
        List<BookingHistory> bookingHistories = bookingService.findAllByUserId(userId);
        if (bookingHistories != null) {
            return ResponseEntity.ok(bookingHistories);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/booking/{user-id}")
    public ResponseEntity<BookingHistory> addBookingRoom(@PathVariable("user-id") Long userId,
                                                         @RequestBody BookingHistory bookingHistory) {
        bookingService.addBooking(
                userId, bookingHistory.getRoom().getId(),
                bookingHistory.getDateFrom(),
                bookingHistory.getDateTo());
        return ResponseEntity.ok(bookingHistory);
    }

    @PutMapping("/booking-edit/{user-id}/{booking-id}")
    public ResponseEntity<BookingHistory> createBooking(@PathVariable("user-id") Long accountId,
                                                        @PathVariable("room-id") Long roomId,
                                                        @RequestBody BookingHistory bookingHistory) {
        BookingHistory booking = bookingService.editBooking(
                accountId, roomId,
                bookingHistory.getDateFrom(),
                bookingHistory.getDateTo());
        return ResponseEntity.ok(booking);
    }

    @PatchMapping("/booking/{booking-id}")
    public String deleteRecord(@PathVariable("booking-id") Long bookingId) {
        bookingService.deleteById(bookingId);
        return "OK";
    }
}
