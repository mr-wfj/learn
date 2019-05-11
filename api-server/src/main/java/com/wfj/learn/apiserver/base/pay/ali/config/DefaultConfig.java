package com.wfj.learn.apiserver.base.pay.ali.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "alipay.default")
@Data
public class DefaultConfig {

    private String appId;
    private String appPrivateKey;
    private String charset;
    private String alipayPublicKey;
    private String notifyUrl;
    private String serverUrl;


}
