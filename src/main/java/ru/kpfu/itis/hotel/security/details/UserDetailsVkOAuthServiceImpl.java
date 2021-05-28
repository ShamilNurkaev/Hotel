package ru.kpfu.itis.hotel.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.hotel.models.User;
import ru.kpfu.itis.hotel.services.OAuthService;

/**
 * 20.02.2021
 * Hotel
 *
 * @author Shamil Nurkaev @nshamil
 * 11-903
 */

@Component("userDetailsVkOAuthService")
public class UserDetailsVkOAuthServiceImpl implements UserDetailsService {

    private final OAuthService oAuthService;

    @Autowired
    public UserDetailsVkOAuthServiceImpl(OAuthService oAuthService) {
        this.oAuthService = oAuthService;
    }

    @Override
    public UserDetails loadUserByUsername(String code) throws UsernameNotFoundException {
        User user = oAuthService.vkAuth(code);
        return new UserDetailsImpl(user);
    }
}
