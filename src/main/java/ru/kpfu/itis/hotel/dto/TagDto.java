package ru.kpfu.itis.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 10.02.2021
 * 06.Hotel
 *
 * @author Shamil Nurkaev @nshamil
 * 11-903
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TagDto {
    String tagName;
}
