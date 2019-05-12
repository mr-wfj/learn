package com.wfj.learn.apiserver.base.pay.wechat.config;

import com.wfj.learn.apiserver.base.pay.PayConst;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: WFJ
 * @Date: 2019/4/30 15:54
 * @Description:
 */
@Configuration(PayConst.WECHATPAY_DEFAULT_ACCOUNT)
@ConfigurationProperties(prefix = PayConst.WECHATPAY_DEFAULT_ACCOUNT)
public class DefaultConfig extends WeChatPayConfig {

}
