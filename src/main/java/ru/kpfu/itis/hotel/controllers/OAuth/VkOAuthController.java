package ru.kpfu.itis.hotel.controllers.OAuth;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 20.02.2021
 * Hotel
 *
 * @author Shamil Nurkaev @nshamil
 * 11-903
 */

@Controller
@RequestMapping("/auth")
public class VkOAuthController {

    @GetMapping("/vk")
    public String socialVk(@Param("code") String code, HttpServletRequest request) {
        return "redirect:/main";
    }
}
