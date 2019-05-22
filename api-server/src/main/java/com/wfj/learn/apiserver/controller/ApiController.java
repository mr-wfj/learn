/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ApiController
 * Author:   mrwfj
 * Date:     2019/5/6 22:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wfj.learn.apiserver.controller;

import com.wfj.learn.apiserver.base.cache.RedisUtils;
import com.wfj.learn.apiserver.base.result.Result;
import com.wfj.learn.apiserver.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author mrwfj
 * @date 2019/5/6
 * @since 1.0.0
 */
@RestController
@EnableCaching
public class ApiController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisUtils redisUtils;

    @GetMapping("/version")
    public Result Version() {
        logger.info("api.version={}", "V1.0");
        return Result.ok("V1.0");
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
