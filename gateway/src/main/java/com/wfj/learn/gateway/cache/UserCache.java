package com.wfj.learn.gateway.cache;




import com.wfj.learn.gateway.consts.JwtConst;
import com.wfj.learn.gateway.redis.RedisUtils;
import com.wfj.learn.gateway.result.Result;
import com.wfj.learn.gateway.result.ResultCode;
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

        // token 验证失败
        if (!jwtUtils.verifyToken(token)) throw new CustomException(Result.failure(ResultCode.TOKEN_TIME_OUT));

        Integer userId = jwtUtils.getUserId(token);

        Object object = redisUtils.get(userTokenKey + userId);
        if (object == null) throw new CustomException(Result.failure(ResultCode.TOKEN_TIME_OUT));

        String tokenStr = object.toString();
        // token 不存在
        if (StringUtils.isBlank(tokenStr)) throw new CustomException(Result.failure(ResultCode.TOKEN_TIME_OUT));
        // token 不同 则:其他设备登录该账号
        if (!token.equals(tokenStr)) throw new CustomException(Result.failure(ResultCode.OTHER_DEVICE_LOGIN));

        return refreshExpire(userId);
    }

    /**
     * 登录成功,保存登录信息
     *
     * @param userInfo 用户
     * @param token    token
     * @return boolean
     */
    public boolean login(UserInfo userInfo, String token) {

        redisUtils.set(userTokenKey + userInfo.getId(), token, JwtConst.EXPIRATION);

        redisUtils.set(userInfoKey + userInfo.getId(), userInfo, JwtConst.EXPIRATION);

        return true;
    }

    /**
     * 退出
     *
     * @param token token
     * @return boolean
     */
    public boolean logout(String token) {
        Integer userId = getUserId(token);

        redisUtils.del(userTokenKey + userId, userInfoKey + userId);

        return true;
    }

    /**
     * 刷新token
     *
     * @param token token
     * @return boolean
     */
    public boolean refreshToken(Integer userId, String token) {
        redisUtils.set(userTokenKey + userId, token, JwtConst.EXPIRATION);
        redisUtils.expire(userTokenKey + userId, JwtConst.EXPIRATION);
        return true;
    }

    /**
     * 刷新 token 超时时间
     *
     * @param userId 用户ID
     * @return boolean
     */
    public boolean refreshExpire(Integer userId) {

        redisUtils.expire(userTokenKey + userId, JwtConst.EXPIRATION);

        redisUtils.expire(userTokenKey + userId, JwtConst.EXPIRATION);

        return true;
    }

    /**
     * 获取用户ID
     *
     * @param token token
     * @return userId
     */
    public Integer getUserId(String token) {
        return jwtUtils.getUserId(token);
    }

    /**
     * 获取用户信息
     *
     * @param token token
     * @return User
     */
    public UserInfo getUser(String token) {
        Integer userId = jwtUtils.getUserId(token);
        return getUser(userId);
    }

    /**
     * 获取用户信息
     *
     * @param userId userId
     * @return User
     */
    public UserInfo getUser(Integer userId) {
        if (userId == null) return null;
        Object object = redisUtils.get(userInfoKey + userId);
        if (object == null) return null;
        return (UserInfo) object;
    }

    /**
     * 更新用户信息
     *
     * @param userInfo 用户信息
     * @return boolean
     */
    public boolean updateUser(UserInfo userInfo) {
        redisUtils.set(userInfoKey + userInfo.getId(), userInfo, JwtConst.EXPIRATION);
        return true;
    }

}
