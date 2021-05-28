package ru.kpfu.itis.hotel.validation;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 01.03.2021
 * 06.Hotel
 *
 * @author Shamil Nurkaev @nshamil
 * 11-903
 */

public class NamesValidator implements ConstraintValidator<ValidNames, Object> {
    private String namePropertyName;
    private String surnamePropertyName;

    @Override
    public void initialize(ValidNames constraintAnnotation) {
        this.namePropertyName = constraintAnnotation.name(); // название поля для name -> firstName
        this.surnamePropertyName = constraintAnnotation.surname(); // название поля для surname -> lastName
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Object name = new BeanWrapperImpl(value).getPropertyValue(namePropertyName); //получили конкретные значения
        Object surname = new BeanWrapperImpl(value).getPropertyValue(surnamePropertyName);

        return name != null && !name.equals(surname);
    }
}

