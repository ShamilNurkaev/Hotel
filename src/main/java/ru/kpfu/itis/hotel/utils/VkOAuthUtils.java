package ru.kpfu.itis.hotel.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.kpfu.itis.hotel.dto.VkAuthToken;
import ru.kpfu.itis.hotel.dto.VkUserDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 25.02.2021
 * Hotel
 *
 * @author Shamil Nurkaev @nshamil
 * 11-903
 */

@Component
public class VkOAuthUtils {

    @Value("${oauth2.vk.v}")
    private String vkApiVersion;

    @Value("${oauth2.vk.client.id}")
    private String vkClientId;

    @Value("${oauth2.vk.client.secret}")
    private String vkClientSecret;

    @Value("${oauth2.vk.redirect-url}")
    private String vkRedirectUrl;

    @Value("${oauth2.vk.api.user.url}")
    private String vkApiUserGetUrl;

    @Value("${oauth2.vk.api.token.url}")
    private String vkApiTokenUrl;

    private static String generateURI(String host, Map<String, String> params) {
        StringBuilder resultURI = new StringBuilder(host);
        if (!params.isEmpty()) {
            resultURI.append("?");
        }
        for (String key : params.keySet()) {
            resultURI.append(key).append("=").append(params.get(key)).append("&");
        }
        if (!params.isEmpty()) {
            resultURI.deleteCharAt(resultURI.length() - 1);
        }
        return resultURI.toString();
    }

    public VkUserDto getUser(VkAuthToken token) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> uriParameters = new HashMap<>();
        uriParameters.put("v", vkApiVersion);
        uriParameters.put("uids", token.getUserId().toString());
        uriParameters.put("access_token", token.getAccessToken());
        String uri = generateURI(vkApiUserGetUrl, uriParameters);

        VKAuthResponse response = restTemplate.getForObject(uri, VKAuthResponse.class);

        if (response != null) {
            Optional<VkUserDto> optional = response.response.stream().findFirst();

            if (optional.isPresent()) {
                return optional.get();
            }
        }

        throw new IllegalArgumentException("Vk authorization failed");
    }

    public VkAuthToken getAuthToken(String code) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> uriParameters = new HashMap<>();
        uriParameters.put("client_id", vkClientId);
        uriParameters.put("client_secret", vkClientSecret);
        uriParameters.put("redirect_uri", vkRedirectUrl);
        uriParameters.put("code", code);
        String uri = generateURI(vkApiTokenUrl, uriParameters);

        return restTemplate.getForObject(uri, VkAuthToken.class);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class VKAuthResponse {
        private List<VkUserDto> response;
    }
}
