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

import com.wfj.learn.apiserver.base.pay.ali.config.AliPayConfig;
import com.wfj.learn.apiserver.base.pay.wechat.config.WeChatPayConfig;
import com.wfj.learn.apiserver.base.result.ResultJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author mrwfj
 * @date 2019/5/6
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/version")
    public String Version() {
        logger.info("api.version={}", "V1.0");
        return "V1.0";
    }

    @Autowired
    private Map<String, AliPayConfig> aliPayConfigMap = new ConcurrentHashMap<>();

    @GetMapping("/ali/config")
    public ResultJson ali_config() {
        logger.info("api.version={}", "V1.0");

        logger.info("alipay.config:{}", aliPayConfigMap);

        return ResultJson.ok(aliPayConfigMap);
    }

    @Autowired
    private Map<String, WeChatPayConfig> weChatPayConfigMap;

    @GetMapping("/wechat/config")
    public ResultJson wechat_config() {
        logger.info("api.version={}", "V1.0");

        logger.info("wechatpay.config:{}", weChatPayConfigMap);

        return ResultJson.ok(weChatPayConfigMap);
    }
}
