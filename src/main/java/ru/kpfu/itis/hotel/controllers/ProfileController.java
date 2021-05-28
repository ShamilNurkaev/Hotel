package ru.kpfu.itis.hotel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.hotel.dto.EditProfileDto;
import ru.kpfu.itis.hotel.models.User;
import ru.kpfu.itis.hotel.security.details.UserDetailsImpl;
import ru.kpfu.itis.hotel.services.UsersService;

import javax.annotation.security.PermitAll;
import java.util.Optional;

/**
 * 01.02.2021
 * 06.Hotel
 *
 * @author Shamil Nurkaev @nshamil
 * 11-903
 */

@Controller
public class ProfileController {

    private final UsersService usersService;

    @Autowired
    public ProfileController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/profile")
    public String getProfilePage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        model.addAttribute("isAuthenticated", userDetails != null);

        Optional<User> userByEmailOptional = usersService.findOneByEmail(userDetails.getUsername());

        if (userByEmailOptional.isPresent()) {
            User user = userByEmailOptional.get();
            model.addAttribute("FirstName", user.getFirstName());
            model.addAttribute("LastName", user.getLastName());
            model.addAttribute("Email", user.getEmail());
        }
        return "profile_page";
    }

    @PostMapping("/profile")
    public String deleteByEmail(@AuthenticationPrincipal UserDetailsImpl user) {
        usersService.deleteByEmail(user.getUsername());
        return "redirect:/main";
    }

    @GetMapping("/profile/edit")
    @PermitAll
    public String getProfilePage(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                 Model model) {
        Optional<User> userByEmailOptional = usersService.findOneByEmail(userDetails.getUsername());
        if (userByEmailOptional.isPresent()) {
            User user = userByEmailOptional.get();
            model.addAttribute("FirstName", user.getFirstName());
            model.addAttribute("LastName", user.getLastName());
        }

        return "edit_profile_page";
    }

    @PostMapping("/profile/edit")
    @PermitAll
    public String editUserProfile(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                  EditProfileDto editProfileDto) {
        String newFirstName = editProfileDto.getFirstName();
        String newLastName = editProfileDto.getLastName();
        String email = userDetails.getUsername();
        usersService.updateFirstNameAndLastNameByEmail(newFirstName, newLastName, email);

        return "redirect:/profile";
    }
}
