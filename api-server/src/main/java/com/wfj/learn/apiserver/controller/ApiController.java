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

import com.wfj.learn.apiserver.base.result.Result;
import com.wfj.learn.apiserver.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
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
public class ApiController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Serializable> redisCacheTemplate;

    @GetMapping("/version")
    public Result Version() {
        logger.info("api.version={}", "V1.0");
        return Result.ok("V1.0");
    }

    @GetMapping("/redis")
    private Result redis() {

        stringRedisTemplate.opsForValue().set("k1", "v1");
        final String k1 = stringRedisTemplate.opsForValue().get("k1");
        logger.info("[字符缓存结果] - [{}]", k1);
        // TODO 以下只演示整合，具体Redis命令可以参考官方文档，Spring Data Redis 只是改了个名字而已，Redis支持的命令它都支持
        String key = "api:user:1";
        redisCacheTemplate.opsForValue().set(key, new User(1L, "u1", "pa"));
        // TODO 对应 String（字符串）
        final User user = (User) redisCacheTemplate.opsForValue().get(key);
        logger.info("[对象缓存结果] - [{}]", user);

        return Result.ok(user);
    }

    @GetMapping("/redis/pool")
    private Result redisPool() {
        // TODO 测试线程安全
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        IntStream.range(0, 1000).forEach(i ->
                executorService.execute(() -> stringRedisTemplate.opsForValue().increment("kk", 1))
        );

        return Result.ok();
    }
}
