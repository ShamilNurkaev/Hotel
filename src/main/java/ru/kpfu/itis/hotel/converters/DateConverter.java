package ru.kpfu.itis.hotel.converters;

import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateConverter implements Converter<String, LocalDate> {

    @Override
    public LocalDate convert(@NotNull String source) {
        try {
            return LocalDate.parse(source, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (DateTimeParseException exception) {
            throw new IllegalArgumentException(exception);
        }
    }
}
