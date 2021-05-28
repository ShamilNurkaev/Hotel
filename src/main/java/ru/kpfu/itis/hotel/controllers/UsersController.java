//package ru.kpfu.itis.hotel.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import ru.kpfu.itis.hotel.services.UsersService;
//
///**
// * 05.04.2021
// * 06.Hotel
// *
// * @author Shamil Nurkaev @nshamil
// * 11-903
// */
//
//@Controller
//public class UsersController {
//
//    private final UsersService usersService;
//
//    @Autowired
//    public UsersController(UsersService usersService) {
//        this.usersService = usersService;
//    }
//
//    @PreAuthorize("hasAuthority('ADMIN_ROLE')")
//    @GetMapping("/users")
//    public String getUsersPage(Model model) {
//        model.addAttribute("usersList", usersService.getAllUsers());
//        return "users_page";
//    }
//
//    @PreAuthorize("hasAuthority('ADMIN_ROLE')")
//    @PostMapping("/addToTable")
//    public @ResponseBody
//    Long addToTable(@RequestParam(value = "firstName") String firstName,
//                    @RequestParam(value = "lastName") String lastName) {
//        return usersService.saveUserWithReturningId(firstName, lastName);
//    }
//
//    @PreAuthorize("hasAuthority('ADMIN_ROLE')")
//    @PostMapping("/ban")
//    public @ResponseBody
//    void banUser(@RequestParam(value = "recordToDelete") String recordToDelete) {
//        usersService.banByEmail(recordToDelete);
//    }
//
//    @PreAuthorize("hasAuthority('ADMIN_ROLE')")
//    @PostMapping("/unban")
//    public @ResponseBody
//    void unbanUser(@RequestParam(value = "recordToDelete") String recordToDelete) {
//        usersService.unbanByEmail(recordToDelete);
//    }
//
//    @PreAuthorize("hasAuthority('ADMIN_ROLE')")
//    @PostMapping("/delete")
//    public @ResponseBody
//    void deleteUser(@RequestParam(value = "recordToDelete") String recordToDelete) {
//        usersService.deleteByEmail(recordToDelete);
//    }
//}
//
