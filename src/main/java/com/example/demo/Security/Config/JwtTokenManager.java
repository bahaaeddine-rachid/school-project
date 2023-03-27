package com.example.demo.Security.Config;

import com.example.demo.Security.ConfigUserDTO.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class JwtTokenManager {

    @Autowired
    private final JwtConfig jwtConfig;

    public JwtTokenManager(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    public Boolean validatetoken (String authToken){
        try{
        Jwts.parser().setSigningKey(jwtConfig.getSecret().getBytes())
                .parseClaimsJwt(authToken);
        return true;
        }catch (Exception e){
            return false;
        }
    }
    public Claims getClaimsFromJwt(String token){
        return Jwts.parser()
                .setSigningKey(jwtConfig.getSecret().getBytes())
                .parseClaimsJws(token)
                .getBody();
    }
    public String generateToken(Authentication authentication){

        Long now = System.currentTimeMillis();
        List<String> tmp=authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim("authorities", tmp)
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now+jwtConfig.getExpiration()*1000))
                .signWith(SignatureAlgorithm.HS512,jwtConfig.getSecret().getBytes())
                .compact();
    }

}
