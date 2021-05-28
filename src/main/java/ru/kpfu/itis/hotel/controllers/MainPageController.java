package ru.kpfu.itis.hotel.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServlet;

/**
 * 10.02.2021
 * 06.Hotel
 *
 * @author Shamil Nurkaev @nshamil
 * 11-903
 */

@Controller
public class MainPageController extends HttpServlet {

    @GetMapping("/main")
    @PermitAll
    public String getMainPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        model.addAttribute("isAuthenticated", userDetails != null);
        return "main_page";
    }
}
