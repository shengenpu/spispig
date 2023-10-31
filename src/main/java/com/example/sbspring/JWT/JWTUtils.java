package com.example.sbspring.JWT;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.sbspring.POJO.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtils {
    private static final String SECRET="bidii";
    private static final long TIME=1000*60;
//    生成Token
    public  static String createToken(User user){
        Date expireDate = new Date(System.currentTimeMillis()+TIME);
        Map<String, Object> map=new HashMap<>();
        map.put("alg","HS256");
        map.put("typ","JWT");
        String token= JWT.create()
                .withHeader(map)

                .withExpiresAt(expireDate)
                .withIssuedAt(new Date())
                .sign(Algorithm.HMAC256(SECRET));
        return token;

    }
//    解析Token
    public static boolean verifyToken(String token){
        try {
            JWTVerifier verifier=JWT.require(Algorithm.HMAC256(SECRET)).build();
            DecodedJWT jwt=verifier.verify(token);
            System.out.println("认证通过：");
            System.out.println("username: " + jwt.getClaim("userName").asString());
            System.out.println("过期时间：      " + jwt.getExpiresAt());
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
