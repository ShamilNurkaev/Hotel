package ru.kpfu.itis.hotel.dto;

import lombok.*;
import ru.kpfu.itis.hotel.models.User;
import ru.kpfu.itis.hotel.validation.ValidNames;
import ru.kpfu.itis.hotel.validation.ValidPassword;

import javax.validation.constraints.Email;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 2
 */

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
// Аннотация ValidNames нужна для проверки сразу двух полей.
// Выводится сообщение errors.invalid.names, если валидация не пройдена.
@ValidNames(
        message = "{errors.invalid.names}",
        name = "firstName",
        surname = "lastName"
)
/*
@ValidConfirmPassword(
        message = "{errors.}"
)
*/
public class UserDto {
    private String firstName;

    private String lastName;

    @Email(message = "{errors.incorrect.email}")
    private String email;

    @ValidPassword(message = "{errors.invalid.password}")
    private String password;

    //TODO: Перенести поле confirmPassword в UserForm
    private String confirmPassword;

    private String uuid;

    private User.State state;

    public static UserDto from(User user) {
        if (user == null) {
            return null;
        }
        return UserDto.builder()
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .state(user.getState())
                .build();
    }

    public static List<UserDto> from(List<User> users) {
        return users.stream()
                .map(UserDto::from)
                .collect(Collectors.toList());
    }
}
