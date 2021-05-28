//package ru.kpfu.itis.hotel.controllers;//package ru.kpfu.itis.group903.nurkaev.controllers;
//
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//import com.google.gson.reflect.TypeToken;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//import ru.kpfu.itis.group903.nurkaev.models.User;
//import ru.kpfu.itis.group903.nurkaev.services.UsersService;
//
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.http.HttpServletRequest;
//import java.lang.reflect.Type;
//import java.util.List;
//
//@MultipartConfig
//@RestController
//public class UserRestController {
//
//    private final UsersService userService;
//
//    @Autowired
//    public UserRestController(UsersService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping(value = "/userRest")
//    public String getAllUsers() {
//        List<User> users = userService.getAllUsers();
//        Type listOfTestObject = new TypeToken<List<User>>() {
//        }.getType();
//        return new GsonBuilder().create().toJson(users, listOfTestObject);
//    }
//
//    @GetMapping(value = "/userRest/{userLogin}")
//    public String getUserById(@PathVariable String userLogin) {
//        User user = userService.findOneByEmail(userLogin);
//        return new GsonBuilder().create().toJson(user);
//    }
//
//    @DeleteMapping(value = "/userRest/{userLogin}")
//    public String deleteUserByLogin(@PathVariable String userLogin) {
//        User user = userService.deleteByEmail(userLogin);
//        return new GsonBuilder().create().toJson(user);
//    }
//
//    @PostMapping(value = "/userRest",
//            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE},
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public String deleteUserByLogin(HttpServletRequest request, @RequestBody String json) {
//        String login;
//        if (request.getContentType().equals("application/x-www-form-urlencoded")) {
//            login = request.getParameter("login");
//        } else {
//            JsonParser parser = new JsonParser();
//            JsonObject obj = parser.parse(json).getAsJsonObject();
//            login = obj.get("login").toString().substring(1, obj.get("login").toString().length() - 1);
//        }
//
//        User user = new User();
//        user.setLogin(login);
//        user.setPassword(login);
//
//        try {
//            userService.saveUser(user);
//        } catch (UserAlreadyExists e) {
//            return new GsonBuilder().create().toJson(e);
//        }
//
//        return new GsonBuilder().create().toJson(user);
//    }
//
//    @RequestMapping(value = "/userRest/{userLogin}",
//            method = RequestMethod.PUT,
//            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE},
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public String updateUserByLogin(@PathVariable String userLogin, HttpServletRequest request) {
//        String newLogin = request.getParameter("newLogin");
//        try {
//            User user = userService.updateUserByLogin(userLogin, newLogin);
//            return new GsonBuilder().create().toJson(user);
//        } catch (Exception e) {
//            return new GsonBuilder().create().toJson(e);
//        }
//    }
//
//}