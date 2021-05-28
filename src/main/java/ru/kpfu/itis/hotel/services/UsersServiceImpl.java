package ru.kpfu.itis.hotel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.hotel.dto.LoginDto;
import ru.kpfu.itis.hotel.dto.UserDto;
import ru.kpfu.itis.hotel.exceptions.DuplicateEntryException;
import ru.kpfu.itis.hotel.exceptions.WrongEmailOrPasswordException;
import ru.kpfu.itis.hotel.models.User;
import ru.kpfu.itis.hotel.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 2
 */

@Service(value = "usersService")
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder encoder;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
        this.encoder = new BCryptPasswordEncoder();
    }

    @Override
    public void save(User entity) {
        usersRepository.save(entity);
    }

    @Override
    public void delete(User entity) {
        usersRepository.delete(entity);
    }

    @Override
    public void deleteByEmail(String email) {
        usersRepository.deleteByEmail(email);
    }

    /*@Override
    public void update(User entity) {
        usersRepository.update(entity);
    }*/

    @Override
    public void updateFirstNameAndLastNameByEmail(String newFirstName, String newLastName, String email) {
        usersRepository.updateFirstNameAndLastNameByEmail(newFirstName, newLastName, email);
    }

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public Optional<User> findOneByEmail(String email) {
        return usersRepository.findOneByEmail(email);
    }

    @Override
    public void signUp(UserDto userDto) throws DuplicateEntryException {
        Optional<User> userOptional = findOneByEmail(userDto.getEmail());
        // Разрешаем регистрацию, если данных нового пользователя нет в БД.
        if (!userOptional.isPresent()) {
            User user = User.builder()
                    .firstName(userDto.getFirstName())
                    .lastName(userDto.getLastName())
                    .email(userDto.getEmail())
                    .role(User.Role.USER_ROLE)
                    .state(User.State.ACTIVE_STATE)
                    .hashPassword(encoder.encode(userDto.getPassword()))
                    .build();
            save(user);
        } else throw new DuplicateEntryException("Пользователь с таким email уже существует.");
    }

    @Override
    public void signIn(LoginDto loginDto) throws WrongEmailOrPasswordException {
        Optional<User> userOptional = findOneByEmail(loginDto.getEmail());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (!encoder.matches(loginDto.getPassword(), user.getHashPassword())) {
                throw new WrongEmailOrPasswordException();
            }
        } else throw new WrongEmailOrPasswordException();
    }

    /*@Override
    public Long saveUserWithReturningId(String firstName, String lastName) {
        return usersRepository.saveUserWithReturningId(firstName, lastName);
    }*/

    /*@Override
    public void banByEmail(String email) {
        usersRepository.banByEmail(email);
    }

    @Override
    public void unbanByEmail(String email) {
        usersRepository.unbanByEmail(email);
    }*/

}
