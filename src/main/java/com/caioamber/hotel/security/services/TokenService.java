package com.caioamber.hotel.security.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.caioamber.hotel.entities.Hospede;
import com.caioamber.hotel.exceptions.TokenException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(Hospede hospede) throws JWTCreationException{
        try{
            return JWT
                    .create()
                    .withIssuer("hotel")
                    .withSubject(hospede.getNomeUsuario())
                    .withClaim("id", hospede.getId())
                    .withExpiresAt(Expirar())
                    .sign(Algorithm.HMAC256(secret));
        } catch (JWTCreationException e){
            throw new RuntimeException("Erro ao gerar token!", e);
        }
    }

    public String getSubject(String tokenJWT) throws JWTCreationException, JWTDecodeException {
        try {
            return JWT
                    .require(Algorithm.HMAC256(secret))
                    .withIssuer("hotel")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTDecodeException e){
            throw new TokenException("Token inválido!");
        } catch (TokenExpiredException e){
            throw new TokenExpiredException("Token expirado!", e.getExpiredOn());
        }
    }

    private Instant Expirar(){
        return LocalDateTime.now()
                .plusHours(2)
                .toInstant(ZoneOffset.of("-03:00"));
    }
}
