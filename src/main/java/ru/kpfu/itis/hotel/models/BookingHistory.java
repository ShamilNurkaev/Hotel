package ru.kpfu.itis.hotel.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * 20.05.2021
 * Hotel
 *
 * @author Shamil Nurkaev @nshamil
 * 11-903
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "booking_hotel")
public class BookingHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    private Date dateFrom;
    private Date dateTo;
}
