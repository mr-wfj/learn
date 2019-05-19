package com.wfj.learn.gateway.utils;


import com.wfj.learn.gateway.consts.JwtConst;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author: WFJ
 */
@Component
public class JwtUtils {

    /**
     * 签名秘钥
     */
    private final String SECRET = "afb3cd5b4c7712c10d49f04fb50550d8";

    /**
     * jwt签发者
     */
    private final String ISSUER = "uinlan";


    private Integer getUserId(String token) {
        final Claims claims = getClaims(token);
        if (claims == null) return null;
        return Integer.valueOf(claims.get(JwtConst.CLAIM_KEY_USER_ID).toString());
    }


    private boolean verifyToken(String token) {
        try {
            final Claims claims = getClaims(token);
            if (claims == null) return false;
            Integer userId = getUserId(token);
            return userId != null;
        } catch (Exception e) {
            return false;
        }
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    private Date generateExpirationDate(long expiration) {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    public String generateToken(String userName, Integer userId) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtConst.CLAIM_KEY_USER_ID, userId);

        return generateToken(userName, claims, JwtConst.EXPIRATION);
    }

    private String generateToken(String subject, Map<String, Object> claims, long expiration) {
        return Jwts.builder()
                .setClaims(claims)                                  //
                .setIssuer(ISSUER)                                  // jwt签发者
                .setSubject(subject)                                // jwt所面向的用户,用户名
                .setId(UUID.randomUUID().toString())                // jti: jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击。
                .setIssuedAt(new Date())                            // iat: jwt的签发时间
                .setExpiration(generateExpirationDate(expiration))  // jwt的过期时间，这个过期时间必须要大于签发时间
                .compressWith(CompressionCodecs.DEFLATE)
                .signWith(SignatureAlgorithm.HS256, SECRET)              //设置签名使用的签名算法和签名使用的秘钥
                .compact();
    }

}
