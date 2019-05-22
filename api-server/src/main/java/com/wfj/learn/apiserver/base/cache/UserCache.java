package com.wfj.learn.apiserver.base.cache;

import com.wfj.learn.apiserver.base.exception.CustomException;
import com.wfj.learn.apiserver.base.result.Result;
import com.wfj.learn.apiserver.base.result.ResultCode;
import com.wfj.learn.apiserver.base.security.JwtConst;
import com.wfj.learn.apiserver.base.security.JwtUtils;
import com.wfj.learn.apiserver.entity.User;
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
     * token 用户信息 关联
     */
    private final String userTokenKey = "user:token:";

    @Autowired
    private JwtUtils jwtUtils;

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

        // token 验证失败
        if (!jwtUtils.verifyToken(token)) throw new CustomException(Result.failure(ResultCode.TOKEN_TIME_OUT));

        Integer userId = jwtUtils.getUserId(token);

        String tokenStr = redisUtils.get(userTokenKey + userId).toString();
        // token 不存在
        if (StringUtils.isBlank(tokenStr)) throw new CustomException(Result.failure(ResultCode.TOKEN_TIME_OUT));
        // token 不同 则:其他设备登录该账号
        if (!token.equals(tokenStr)) throw new CustomException(Result.failure(ResultCode.OTHER_DEVICE_LOGIN));

        return true;
    }

    /**
     * 登录成功,保存登录信息
     *
     * @param user  用户
     * @param token token
     * @return boolean
     */
    public boolean setUser(User user, String token) {

        redisUtils.set(userTokenKey + user.getId(), token, JwtConst.EXPIRATION);

        redisUtils.set(userInfoKey + user.getId(), user, JwtConst.EXPIRATION);

        return true;
    }

    /**
     * 退出
     *
     * @param token token
     * @return
     */
    public boolean out(String token) {
        Integer userId = getUserId(token);

        redisUtils.del(userTokenKey + userId, userInfoKey + userId);

        return true;
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
    private User getUser(String token) {
        Integer userId = jwtUtils.getUserId(token);
        if (userId == null) throw new CustomException(Result.failure(ResultCode.TOKEN_TIME_OUT));

        User user = (User) redisUtils.get(userInfoKey + userId);
        if (user == null) throw new CustomException(Result.failure(ResultCode.TOKEN_TIME_OUT));

        return user;
    }

}
