package com.wfj.learn.common.jwt;

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


    /**
     * 用户ID
     */
    public static final String CLAIM_KEY_USER_ID = "userId";
    /**
     * 用户名/账号名
     */
    public static final String CLAIM_KEY_USER_NAME = "userName";
    /**
     * 手机号
     */
    public static final String CLAIM_KEY_MOBILE = "mobile";
    /**
     * 角色
     */
    public static final String CLAIM_KEY_AUTHORITIES = "roles";

}
