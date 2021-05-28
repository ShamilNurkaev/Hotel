package ru.kpfu.itis.hotel.services;


import ru.kpfu.itis.hotel.dto.LoginDto;
import ru.kpfu.itis.hotel.dto.UserDto;
import ru.kpfu.itis.hotel.exceptions.DuplicateEntryException;
import ru.kpfu.itis.hotel.exceptions.WrongEmailOrPasswordException;
import ru.kpfu.itis.hotel.models.User;

import java.util.List;
import java.util.Optional;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 2
 */

public interface UsersService {
    void save(User entity);
    void delete(User entity);
    void deleteByEmail(String email);

    void updateFirstNameAndLastNameByEmail(String newFirstName, String newLastName, String email);
    List<User> getAllUsers();
    Optional<User> findById(Long id);
    Optional<User> findOneByEmail(String email);

    void signUp(UserDto userDto) throws DuplicateEntryException;
    void signIn(LoginDto loginDto) throws WrongEmailOrPasswordException;

   /* Long saveUserWithReturningId(String firstName, String lastName);
    void banByEmail(String parseLong);
    void unbanByEmail(String parseLong);*/
}
