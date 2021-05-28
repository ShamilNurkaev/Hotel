package ru.kpfu.itis.hotel.dto;

import lombok.*;

/**
 * 20.04.2021
 * 06.Hotel
 *
 * @author Shamil Nurkaev @nshamil
 * 11-903
 */

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
/*// Аннотация ValidNames нужна для проверки сразу двух полей.
// Выводится сообщение errors.invalid.names, если валидация не пройдена.
@ValidNames(
        message = "{errors.invalid.names}",
        name = "firstName",
        surname = "lastName"
)*/
public class EditProfileDto {
    private String firstName;
    private String lastName;
}
