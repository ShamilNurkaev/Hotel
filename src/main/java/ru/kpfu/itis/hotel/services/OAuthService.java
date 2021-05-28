package ru.kpfu.itis.hotel.services;

import ru.kpfu.itis.hotel.models.User;

/**
 * 20.02.2021
 * Hotel
 *
 * @author Shamil Nurkaev @nshamil
 * 11-903
 */

public interface OAuthService {
    User vkAuth(String code);
}
