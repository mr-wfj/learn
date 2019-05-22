package com.wfj.learn.apiserver.controller;

import com.wfj.learn.apiserver.base.result.Result;
import com.wfj.learn.apiserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(String userName, String password) {
        return Result.ok(userService.login(userName, password));
    }
}
