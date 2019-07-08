package com.wfj.learn.apiserver.controller;

import com.wfj.learn.apiserver.base.cache.RedisUtils;
import com.wfj.learn.apiserver.base.result.Result;
import com.wfj.learn.apiserver.base.result.ResultCode;
import com.wfj.learn.apiserver.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/test")
public class TestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisUtils redisUtils;

    @GetMapping("/timeout")
    public Result timeout() {
        try {
            //睡5秒，网关Hystrix3秒超时，会触发熔断降级操作
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.failure(ResultCode.TIME_OUT, "timeout");
    }

    @GetMapping("/redis")
    private Result redis() {

        redisUtils.set("token", "xxx", 60 * 60 * 7);

        final String token = redisUtils.get("token").toString();
        logger.info("[字符缓存结果] - [{}]", token);

        // TODO 以下只演示整合，具体Redis命令可以参考官方文档，Spring Data Redis 只是改了个名字而已，Redis支持的命令它都支持
        String key = "api:user:1";

        User user = User.builder().id(1).userName("u1").password("pa").build();
        redisUtils.set(key, user);

        // TODO 对应 String（字符串）
        final User userInfo = (User) redisUtils.get(key);
        logger.info("[对象缓存结果] - [{}]", userInfo);

        return Result.ok(user);
    }

    @GetMapping("/redis/pool")
    private Result redisPool() {
        // TODO 测试线程安全
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        IntStream.range(0, 1000).forEach(i ->
                executorService.execute(() -> redisUtils.incr("i", 1))
        );

        return Result.ok();
    }
}
