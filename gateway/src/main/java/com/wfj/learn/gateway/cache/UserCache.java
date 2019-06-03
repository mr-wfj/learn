package com.wfj.learn.gateway.cache;


import com.wfj.learn.gateway.redis.RedisUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserCache {

    /**
     * 用户信息Key
     */
    private final String userInfoKey = "user:info:";

    /**
     * 用户 验证 token
     */
    private final String userTokenKey = "user:auth:";

    @Autowired
    private RedisUtils redisUtils;

    /**
     * token 验证
     *
     * @param token token
     * @return boolean
     */
    public boolean verifyToken(String token) {
        if (StringUtils.isBlank(token)) return false;

        Object object = redisUtils.get(userTokenKey + token);

        return object != null;
    }


    /**
     * 获取用户ID
     *
     * @param token token
     * @return userId
     */
    public Integer getUserId(String token) {
        return getUser(token).getId();
    }

    /**
     * 获取用户信息
     *
     * @param token token
     * @return User
     */
    public UserInfo getUser(String token) {
        if (StringUtils.isBlank(token)) return null;
        Object object = redisUtils.get(token);
        return (UserInfo) object;
    }

}
