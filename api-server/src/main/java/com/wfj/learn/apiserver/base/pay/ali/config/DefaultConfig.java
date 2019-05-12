package com.wfj.learn.apiserver.base.pay.ali.config;


import com.wfj.learn.apiserver.base.pay.PayConst;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component(PayConst.ALIPAY_DEFAULT_ACCOUNT)
@ConfigurationProperties(prefix = PayConst.ALIPAY_DEFAULT_ACCOUNT)
public class DefaultConfig extends AliPayConfig {


}
