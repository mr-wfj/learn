package com.wfj.learn.apiserver.service;

public interface UserService {

    /**
     * 登录
     *
     * @param userName 用户名[账户名,手机号]
     * @param password 密码
     * @return 登录成功-返回token
     */
    String login(String userName, String password);

    /**
     * 登出
     *
     * @param token token
     * @return boolean
     */
    boolean out(String token);

}
