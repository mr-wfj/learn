package com.wfj.learn.apiserver.base.pay.ali.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("alipay.default")
@ConfigurationProperties(prefix = "alipay.default")
public class DefaultConfig extends AliPayConfig {


}
