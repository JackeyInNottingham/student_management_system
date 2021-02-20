package com.jackeyj.sms.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * @author jiyaofei
 */
public class JWTUtils {

    private static String SIGN_KEY = "test";

    public static String getToken(Map<String, String> map){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.MINUTE,60);

        JWTCreator.Builder builder = JWT.create();

        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });

        String token = builder
                .withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(SIGN_KEY));

        return token;
    }

    public static DecodedJWT verify(String token){
        return JWT.require(Algorithm.HMAC256(SIGN_KEY)).build().verify(token);
    }


}
