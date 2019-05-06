/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: HelloController
 * Author:   mrwfj
 * Date:     2019/5/6 21:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wfj.feign.controller;

import com.wfj.feign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author mrwfj
 * @create 2019/5/6
 * @since 1.0.0
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/say")
    public String say() {
        return helloService.say();
    }

}
