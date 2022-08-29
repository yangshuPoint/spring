package com.sys.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;

public class Jwtutil {

    static String key = "#@dsrfwe%^&dfg(*dc";

    /**
     * @param payload 一般 map(username,password)
     * @return
     */

    public static String getToken(String payload) {

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 120);

        String token = JWT.create()
                .withClaim("name", payload)
                .withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(key));
        return token;
    }


    /**
     * a验证token   验证从head中取出的token
     *
     * @param token
     * @return
     */
    public static DecodedJWT verif(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(key)).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        return decodedJWT;
    }

}
