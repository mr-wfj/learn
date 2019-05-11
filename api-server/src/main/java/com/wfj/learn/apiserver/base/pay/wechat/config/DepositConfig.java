package com.wfj.learn.apiserver.base.pay.wechat.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: WFJ
 * @Date: 2019/4/30 15:43
 * @Description:
 */
@Component
@ConfigurationProperties(prefix = "wechat.deposit")
@Data
public class DepositConfig extends WeChatPayConfig {


}
