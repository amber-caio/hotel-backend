package com.caioamber.hotel.security.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.caioamber.hotel.entities.User;
import com.caioamber.hotel.exceptions.TokenException;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    // Criando o logger
    private static final Logger logger = LoggerFactory.getLogger(TokenService.class);

    public String gerarToken(User user) throws JWTCreationException{
        try {
            return JWT
                    .create()
                    .withIssuer("hotel")
                    .withSubject(user.getUsername())
                    .withClaim("id", user.getId())
                    .withExpiresAt(Expirar())
                    .sign(Algorithm.HMAC256(secret));
        } catch (JWTCreationException e){
            logger.error("Erro ao gerar token!", e);
            throw new RuntimeException("Erro ao gerar token!", e);
        }
    }

    public String getSubject(String tokenJWT) throws JWTCreationException, JWTDecodeException{
        try {
            return JWT
                    .require(Algorithm.HMAC256(secret))
                    .withIssuer("hotel")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTDecodeException e){
            logger.error("Token inválido!");
            throw new TokenException("Token inválido!");
        }
        catch (TokenExpiredException e){
            throw new TokenExpiredException("Token expirado!", e.getExpiredOn());
        }
    }

    private Instant Expirar(){
        return LocalDateTime.now()
                .plusHours(2)
                .toInstant(ZoneOffset.of("-03:00"));
    }
}
