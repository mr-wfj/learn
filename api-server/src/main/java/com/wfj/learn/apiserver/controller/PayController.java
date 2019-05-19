package com.wfj.learn.apiserver.controller;

import com.wfj.learn.apiserver.base.order.PayOrder;
import com.wfj.learn.apiserver.base.pay.BasePayFactory;
import com.wfj.learn.apiserver.base.pay.PayConst;
import com.wfj.learn.apiserver.base.pay.ali.config.AliPayConfig;
import com.wfj.learn.apiserver.base.pay.wechat.config.WeChatPayConfig;
import com.wfj.learn.apiserver.base.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/pay")
public class PayController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Map<String, AliPayConfig> aliPayConfigMap = new ConcurrentHashMap<>();

    @GetMapping("/ali/config")
    public Result ali_config() {
        logger.info("api.version={}", "V1.0");

        logger.info("alipay.config:{}", aliPayConfigMap);

        return Result.ok(aliPayConfigMap);
    }

    @PostMapping("/ali/pay")
    public Result ali_pay() {
        logger.info("api.version={}", "V1.0");

        PayOrder payOrder = PayOrder.builder().number("123456789").amount(1.0).description("测试商品001").build();
        basePayFactory.getcontext(PayConst.ALI_PAY).pay(payOrder);

        return Result.ok(aliPayConfigMap);
    }

    @Autowired
    private Map<String, WeChatPayConfig> weChatPayConfigMap;

    @GetMapping("/wechat/config")
    public Result wechat_config() {
        logger.info("api.version={}", "V1.0");

        logger.info("wechatpay.config:{}", weChatPayConfigMap);

        return Result.ok(weChatPayConfigMap.toString());
    }


    @Autowired
    private BasePayFactory basePayFactory;

    @PostMapping("/wechat/pay")
    public Result wechat_pay() {
        logger.info("api.version={}", "V1.0");

        PayOrder payOrder = PayOrder.builder().number("123456789").amount(1.0).description("测试商品001").build();
        basePayFactory.getcontext(PayConst.WECHAT_PAY).pay(payOrder);
        logger.info("wechatpay.config:{}", weChatPayConfigMap);

        return Result.ok(weChatPayConfigMap.toString());
    }
}
