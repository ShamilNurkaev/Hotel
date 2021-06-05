package ru.kpfu.itis.hotel.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.kpfu.itis.hotel.exceptions.HotelApplicationException;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerController {

    /*@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DuplicateEntryException.class)
    public String handleDuplicateEntry(HttpServletRequest request, Exception exception, Model model) {
        model.addAttribute("duplicateEntryMessage", "Пользователь с таким email уже существует.");
        return "sign_up_page";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(WrongEmailOrPasswordException.class)
    public String handleWrongEmailOrPassword(Model model) {
        model.addAttribute("wrongEmailOrPasswordMessage", "Неправильный логин или пароль.");
        return "sign_in_page";
    }*/

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public String postException() {
        return "exception_page";
    }

    @ExceptionHandler(RuntimeException.class)
    public void postRuntimeException(HotelApplicationException exception) {
        log.error(exception.toString());
        log.error(exception.getMessage());
    }
}