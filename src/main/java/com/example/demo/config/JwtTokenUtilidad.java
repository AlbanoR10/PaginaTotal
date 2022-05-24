package com.example.demo.config;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Clase JwtTokenUtilidad que lidea con los tokens
*
 */
@Component
public class JwtTokenUtilidad implements Serializable {

    /**
     * Variable para serializar
     */
    private static final long serialVersionUID = -2550185165626007488L;

    /**
     * Token de validacion
     */
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    /**
     * Variable JWT secret
     */
    @Value("${jwt.secret}")
    private String secreto;

    /**
    * Metodo para agregar cotizaciones al set de cotizaciones
    * @param token objeto de la clase cotizacion
    * @return nombre de usuario desde el token
    **/
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    /**
    * Metodo para agregar cotizaciones al set de cotizaciones
    * @param token 
    * @return problemas del token
    **/
    public Date getIssuedAtDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getIssuedAt);
    }

    /**
    * Metodo para agregar cotizaciones al set de cotizaciones
    * @param token 
    * @return expiracion del token
    **/
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    /**
    * Metodo para agregar cotizaciones al set de cotizaciones
    * @param token 
    * @param claimsResolver 
    * @return privilegios del token
    **/
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    /**
    * Metodo para agregar cotizaciones al set de cotizaciones
    * @param token objeto de la clase cotizacion
    * @return privilegios del token
    **/
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secreto).parseClaimsJws(token).getBody();
    }

    /**
    * Metodo para agregar cotizaciones al set de cotizaciones
    * @param token objeto de la clase cotizacion
    * @return si el token esta expirado
    **/
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    /**
    * Metodo para agregar cotizaciones al set de cotizaciones
    * @param token objeto de la clase cotizacion
    * @return false siempre
    **/
    private Boolean ignoreTokenExpiration(String token) {
        // here you specify tokens, for that the expiration is ignored
        return false;
    }

    /**
    * Metodo para agregar cotizaciones al set de cotizaciones
    * @param userDetails objeto de la clase cotizacion
    * @return token
    **/
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails.getUsername());
    }

    /**
    * Metodo para agregar cotizaciones al set de cotizaciones
    * @param claims
    * @param subject 
    * @return si es un token expirado 
    **/
    private String doGenerateToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000)).signWith(SignatureAlgorithm.HS512, secreto).compact();
    }

    /**
    * Metodo para agregar cotizaciones al set de cotizaciones
    * @param token 
    * @return si es un token expirado 
    **/
    public Boolean canTokenBeRefreshed(String token) {
        return (!isTokenExpired(token) || ignoreTokenExpiration(token));
    }

    /**
    * Metodo para agregar cotizaciones al set de cotizaciones
    * @param token 
    * @param userDetails objeto de la clase cotizacion
    * @return si es un token valido
    **/
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
