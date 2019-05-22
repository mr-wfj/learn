package com.wfj.learn.apiserver.base.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
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


    public Integer getUserId(String token) {
        final Claims claims = getClaims(token);
        if (claims == null) return null;
        return Integer.valueOf(claims.get(JwtConst.CLAIM_KEY_USER_ID).toString());
    }


    /**
     * 验证token
     *
     * @param token token
     * @return boolean
     */
    public boolean verifyToken(String token) {
        try {
            final Claims claims = getClaims(token);
            // token 错误
            if (claims == null) return false;

            // token 超时 失效
            if (claims.getExpiration().before(new Date())) return false;

            // 获取用户ID为空 失效
            return StringUtils.isBlank(claims.get(JwtConst.CLAIM_KEY_USER_ID).toString());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 生成token 并返回
     *
     * @param userName 用户名
     * @param userId   用户ID
     * @return token 字符串
     */
    public String generateToken(String userName, Integer userId) {
        return generateToken(userName, userId, null);
    }

    /**
     * 生成token 并返回
     *
     * @param userName 用户名
     * @param userId   用户ID
     * @param mobile   手机号
     * @return token 字符串
     */
    public String generateToken(String userName, Integer userId, String mobile) {
        Map<String, Object> claims = new HashMap<>();

        if (StringUtils.isNotBlank(userName)) claims.put(JwtConst.CLAIM_KEY_USER_NAME, userName);
        if (userId != null) claims.put(JwtConst.CLAIM_KEY_USER_ID, userId);
        if (StringUtils.isNotBlank(mobile)) claims.put(JwtConst.CLAIM_KEY_MOBILE, mobile);

        return generateToken(userName, claims, JwtConst.EXPIRATION);
    }

    /**
     * 获取 Claims
     *
     * @param token token
     * @return Claims
     */
    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 获取超时时间
     *
     * @param expiration long
     * @return Date
     */
    private Date generateExpirationDate(long expiration) {
        return new Date(System.currentTimeMillis() + expiration * 1000);
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
