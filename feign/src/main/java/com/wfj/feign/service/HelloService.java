/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: HelloService
 * Author:   mrwfj
 * Date:     2019/5/6 21:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wfj.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author mrwfj
 * @create 2019/5/6
 * @since 1.0.0
 */
@FeignClient(name = "helloService", url = "http://192.168.0.108:8081")
public interface HelloService {

    @GetMapping("/hello/say1")
    String say();
}
