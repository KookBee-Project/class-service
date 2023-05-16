package com.KookBee.classservice.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
@RequiredArgsConstructor
public class JwtService {
    @Value("${jwt.ACCESS_SECRET_KEY}")
    private String AccessSecret;

    public String getAccessToken() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        return request.getHeader("AccessToken");
    }

    public TokenInfo tokenToDTO(String accessToken){
        try{
            Claims claims = Jwts
                    .parserBuilder()
                    .setSigningKey(AccessSecret)
                    .build()
                    .parseClaimsJws(accessToken)
                    .getBody();
            TokenInfo info = new TokenInfo().tokenToDTO(claims);
            return info;
        }catch (Exception e){
            return null;
        }
    }

}
