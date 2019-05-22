package com.wfj.learn.apiserver.service.impl;


import com.wfj.learn.apiserver.base.cache.UserCache;
import com.wfj.learn.apiserver.base.security.JwtUtils;
import com.wfj.learn.apiserver.entity.User;
import com.wfj.learn.apiserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserCache userCache;

    @Autowired
    private JwtUtils jwtUtils;


    @Override
    public String login(String userName, String password) {
        User user = User.builder().userName("wfj").password("123456").mobile("18566217093").build();

        String token = jwtUtils.generateToken(userName, user.getId(), user.getMobile());
        userCache.setUser(user, token);

        return token;
    }

    @Override
    public boolean out(String token) {
        return userCache.out(token);
    }
}
