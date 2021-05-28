package ru.kpfu.itis.hotel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.hotel.aspects.Loggable;
import ru.kpfu.itis.hotel.dto.UserDto;
import ru.kpfu.itis.hotel.exceptions.DuplicateEntryException;
import ru.kpfu.itis.hotel.services.UsersService;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import java.util.Objects;

/**
 * 01.02.2021
 * 06.Hotel
 *
 * @author Shamil Nurkaev @nshamil
 * 11-903
 */

@Controller
public class SignUpController {
    private final UsersService usersService;

    @Autowired
    public SignUpController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PermitAll
    @GetMapping(value = "/signUp")
    public String getSignUpPage(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "sign_up_page";
    }

    @PermitAll
    @Loggable
    @PostMapping(value = "/signUp")
    public String signUpUser(@Valid UserDto userDto, BindingResult bindingResult, ModelMap map) {
        System.out.println(userDto);
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                if (Objects.requireNonNull(error.getCodes())[0].equals("userDto.ValidNames")) {
                    map.put("namesErrorMessage", error.getDefaultMessage());
                }
            }
            map.put("userDto", userDto);
            return "sign_up_page";
        }
        try {
            usersService.signUp(userDto);
            return "redirect:/signIn";
        } catch (DuplicateEntryException e) {
            map.put("message", "Пользователь с таким email уже существует.");
            return "sign_up_page";
        }
    }
}
