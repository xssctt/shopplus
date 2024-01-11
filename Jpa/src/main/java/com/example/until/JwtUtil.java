package com.example.until;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.entity.Member;
import com.example.entity.User;
import com.example.execption.JWTVerificationExnception;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class JwtUtil<T> {
    //Jwt秘钥
    private static final String key = "abcdefghijklmn";

    //根据用户信息创建Jwt令牌
    public static String createJwt(Member member){
        Algorithm algorithm = Algorithm.HMAC256(key);
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        calendar.add(Calendar.SECOND, 3600 * 24 * 7);
        return JWT.create()
                .withClaim("name", member.getName())  //配置JWT自定义信息
                .withClaim("id",member.getId())
//                .withClaim("authorities", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
                .withExpiresAt(calendar.getTime())  //设置过期时间
                .withIssuedAt(now)    //设置创建创建时间
                .sign(algorithm);   //最终签名
    }

    //根据Jwt验证并解析用户信息
    public static Member resolveJwt(String token){
        Algorithm algorithm = Algorithm.HMAC256(key);
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        try {
            DecodedJWT verify = jwtVerifier.verify(token);  //对JWT令牌进行验证，看看是否被修改
            Map<String, Claim> claims = verify.getClaims();  //获取令牌中内容
            if(new Date().after(claims.get("exp").asDate())) //如果是过期令牌则返回null
                return null;
            else
                //重新组装为UserDetails对象，包括用户名、授权信息等
                return Member.builder()
                        .name(claims.get("name").asString())
                        .id(claims.get("id").asInt())
//                        .authorities(claims.get("authorities").asArray(String.class))
                        .build();
        } catch (JWTVerificationExnception e) {
            return null;
        }
    }
}