package ru.kpfu.itis.hotel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
//import ru.kpfu.itis.group903.nurkaev.aspects.Loggable;
import ru.kpfu.itis.hotel.dto.LoginDto;
import ru.kpfu.itis.hotel.exceptions.WrongEmailOrPasswordException;
import ru.kpfu.itis.hotel.services.UsersService;

import javax.annotation.security.PermitAll;

/**
 * 01.02.2021
 * 06.Hotel
 *
 * @author Shamil Nurkaev @nshamil
 * 11-903
 */

@Controller
@SessionAttributes(value = "Email")
public class SignInController {

    private final UsersService usersService;

    @Autowired
    public SignInController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PermitAll
    @GetMapping(value = "/signIn")
//    @Loggable
    public String getSignInPage() {
        System.out.println("hello");
        return "sign_in_page";
    }

    @PermitAll
    @PostMapping(value = "/signIn")
//    @Loggable
    public String signInUser(ModelMap map, LoginDto loginDto) {
        try {
            usersService.signIn(loginDto);
            //TODO: хранить в сессии объект User вместо Email
            map.put("Email", loginDto.getEmail());
            return "redirect:/main";
        } catch (WrongEmailOrPasswordException e) {
            map.put("wrongEmailOrPasswordMessage", "Неправильный логин или пароль.");
        }

        return "redirect:/signIn";
    }
}
