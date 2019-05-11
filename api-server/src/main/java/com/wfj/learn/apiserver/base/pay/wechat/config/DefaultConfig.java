package com.wfj.learn.apiserver.base.pay.wechat.config;

import com.wfj.learn.apiserver.base.pay.PayConst;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: WFJ
 * @Date: 2019/4/30 15:54
 * @Description:
 */
@Configuration(PayConst.WECHATPAY_DEFAULT_ACCOUNT)
@ConfigurationProperties(prefix = "wechat.default")
@Data
public class DefaultConfig extends WeChatPayConfig {

}
