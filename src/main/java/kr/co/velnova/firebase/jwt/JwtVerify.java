package kr.co.velnova.firebase.jwt;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class JwtVerify {

    public String getJwt(String bearer) {
        String bearerToken = null;
        if (StringUtils.hasText(bearer) && bearer.startsWith("Bearer ")) {
            bearerToken = bearer.substring(7);
        }
        return bearerToken;
    }
}
