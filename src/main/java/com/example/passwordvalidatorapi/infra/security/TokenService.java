package com.example.passwordvalidatorapi.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.passwordvalidatorapi.domain.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.aspectj.bridge.MessageUtil.fail;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;
    public String generateToken(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            String token = JWT.create()
                    .withIssuer("login-auth-api")
                    .withSubject(user.getEmail())
                    .withSubject(user.getPassword())
                    .withExpiresAt(this.generateExpirationDate())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception){
            throw new RuntimeException("Error while authenticating");
        }
    }

    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("login-auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            return null;
        }
    }

    private Instant generateExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    public boolean validatePassword(String password) {
        boolean result = false;

        try {
            if (password != null) {
                String MIN_LENGTH = "8";
                String MAX_LENGTH = "20";
                boolean SPECIAL_CHAR_NEEDED = false;

                String ONE_DIGIT = "(?=.*[0-9])";
                String LOWER_CASE = "(?=.*[a-z])";
                String UPPER_CASE = "(?=.*[A-Z])";
                String SPECIAL_CHAR = SPECIAL_CHAR_NEEDED ? "(?=.*[@#$%^&+=])" : "";
                String NO_SPACE = "(?=\\S+$)";

                String MIN_MAX_CHAR = ".{" + MIN_LENGTH + "," + MAX_LENGTH + "}";
                String PATTERN = ONE_DIGIT + LOWER_CASE + UPPER_CASE + SPECIAL_CHAR + NO_SPACE + MIN_MAX_CHAR;
                Pattern p = Pattern.compile(PATTERN);


                Matcher m = p.matcher(password);

                return m.matches();
            }
        }catch (Exception ex){
            ex.printStackTrace();
            fail("Password Invalid:" + ex.getMessage());
        }
        return result;
    }
}
