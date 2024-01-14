package com.shop.persistence.security.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
@Log4j2
public class JwtUtils {
    @Value("${jwt.secret.key}")
    private String secretKey;
    @Value("${jwt.time.expiration}")
    private String timeExpiration;

    // Generar Token de acceso
    public String generateAccessToken(String userName){
        return Jwts.builder()
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+Long.parseLong(timeExpiration)))
                .signWith(getSignatureKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    // Validar el token de acceso
    public boolean isTokenValid(String token){
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSignatureKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return true;
        }catch(Exception e){
            log.error("Error invalido, error: ".concat(e.getMessage()));
            return false;
        }
    }
    // Obtener  username del Token
    public String getUserNameFromToken(String token){
        return getClaims(token,Claims::getSubject);
    }
    //Obtener un solo claim
    public <T> T getClaims(String token, Function<Claims,T> claimsTFunction){
        Claims claims=extractAllClaims(token);
        return claimsTFunction.apply(claims);
    }
    // Obtener todos los claims del token
    public Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSignatureKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    //Obtener firma del token
    public Key getSignatureKey(){
       byte[] keyBytes= Decoders.BASE64.decode(secretKey);
       return Keys.hmacShaKeyFor(keyBytes);
        //return Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }


}
