package ru.kpfu.itis.hotel.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 01.03.2021
 * 06.Hotel
 *
 * @author Shamil Nurkaev @nshamil
 * 11-903
 */

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.trim().length() > 8 && value.matches(".*[A-Z].*") &&
                value.matches(".*[a-z].*") && value.matches(".*[0-9].*");
    }
}
