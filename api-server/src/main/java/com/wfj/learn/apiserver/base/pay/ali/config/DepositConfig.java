package com.wfj.learn.apiserver.base.pay.ali.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: WFJ
 * @Date: 2019/4/30 15:43
 * @Description:
 */
@Component("alipay.deposit")
@ConfigurationProperties(prefix = "alipay.deposit")
public class DepositConfig extends AliPayConfig {


}
