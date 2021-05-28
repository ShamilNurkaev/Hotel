package ru.kpfu.itis.hotel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.hotel.dto.VkAuthToken;
import ru.kpfu.itis.hotel.dto.VkUserDto;
import ru.kpfu.itis.hotel.models.User;
import ru.kpfu.itis.hotel.repositories.UsersRepository;
import ru.kpfu.itis.hotel.utils.VkOAuthUtils;

import java.util.Optional;

/**
 * 20.02.2021
 * Hotel
 *
 * @author Shamil Nurkaev @nshamil
 * 11-903
 */

@Service
public class OAuthServiceImpl implements OAuthService {

    private final UsersRepository usersRepository;
    private final VkOAuthUtils vkUtils;

    @Autowired
    public OAuthServiceImpl(UsersRepository usersRepository, VkOAuthUtils vkUtils) {
        this.usersRepository = usersRepository;
        this.vkUtils = vkUtils;
    }

    @Override
    public User vkAuth(String code) {
        VkAuthToken authToken = vkUtils.getAuthToken(code);

        if (authToken.getEmail() != null) {
            Optional<User> optionalUser = usersRepository.findByEmail(authToken.getEmail());

            if (optionalUser.isPresent()) {
                return optionalUser.get();
            }

            VkUserDto vkUserDto = vkUtils.getUser(authToken);
            User user = User.builder()
                    .firstName(vkUserDto.getFirstName())
                    .lastName(vkUserDto.getLastName())
                    .email(authToken.getEmail())
                    .state(User.State.ACTIVE_STATE)
                    .role(User.Role.USER_ROLE)
                    .build();

            return usersRepository.save(user);
        }

        throw new IllegalArgumentException("Vk authorization failed. User is not found.");
    }
}
