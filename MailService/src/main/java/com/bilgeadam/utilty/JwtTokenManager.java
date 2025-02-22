package com.bilgeadam.utilty;



import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class JwtTokenManager {
    private final String SECRETKEY ="secretkey";
    private final String ISSUER ="workforce";
    private final Long EXDATE = 1000L * 60 * 60 ;

    public Optional<String> createToken (Long authId){
        String token;
        try{
            token = JWT.create().withAudience()
                    .withClaim("authId", authId)
                    .withIssuer(ISSUER)
                    .withIssuedAt(new Date())
                    .withExpiresAt(new Date(System.currentTimeMillis() + EXDATE))
                    .sign(Algorithm.HMAC512(SECRETKEY));
            return Optional.of(token);
        }catch (Exception e){
            return Optional.empty();
        }
    }




    //  Şifre Sıfırlama İçin Email İle Token Oluşturma
    public Optional<String> createPasswordResetToken(String email){
        String token;
        try {
            token = JWT.create()
                    .withClaim("email", email) // Email'i token içinde saklıyoruz
                    .withIssuer(ISSUER)
                    .withIssuedAt(new Date()) // Şu anki tarih
                    .withExpiresAt(new Date(System.currentTimeMillis() + EXDATE)) // Token geçerlilik süresi
                    .sign(Algorithm.HMAC512(SECRETKEY)); // HMAC512 algoritması ile imzalama
            return Optional.of(token);
        } catch (Exception e) {
            return Optional.empty();
        }
    }






}