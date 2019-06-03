package com.wfj.learn.apiserver.controller;

import com.wfj.learn.apiserver.base.result.Result;
import com.wfj.learn.apiserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(String userName, String password, HttpServletRequest request) {
        String userId = request.getHeader("userId");

        return Result.ok(userService.login(userName, password));
    }

    @PostMapping("/out")
    public Result out(String token) {
        return Result.ok(userService.out(token));
    }

    @GetMapping("/info")
    public Result info(String token) {
        return Result.ok(userService.getUserInfo(token));
    }
}
