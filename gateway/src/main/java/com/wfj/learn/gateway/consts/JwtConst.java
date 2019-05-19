package com.wfj.learn.gateway.consts;

/**
 * @Author: WFJ
 * @Date: 2019/4/19 14:15
 * @Description: JWT token 常量
 */
public final class JwtConst {

    private JwtConst() {
    }

    /**
     * http 头部
     */
    public final static String AUTH_HEADER = "Authorization";

    /**
     * token 头部
     */
    public final static String TOKEN_HEAD = "Bearer ";

    /**
     * token 头部长度
     */
    public final static int TOKEN_HEAD_LENGTH = 7;

    /**
     * 有效期:单位/秒 token有效期一天
     */
    public final static long EXPIRATION = 86400;


    public static final String ROLE_REFRESH_TOKEN = "ROLE_REFRESH_TOKEN";

    public static final String CLAIM_KEY_USER_ID = "user_id";
    //private static final String CLAIM_KEY_AUTHORITIES = "scope";
    public static final String CLAIM_KEY_AUTHORITIES = "roles";


}
