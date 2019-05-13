package com.wfj.learn.apiserver.base.pay.wechat.config;


import com.wfj.learn.apiserver.base.pay.PayConst;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: WFJ
 * @Date: 2019/5/7 17:00
 * @Description:
 */
@Component(PayConst.WECHATPAY_DEPOSIT_ACCOUNT)
@ConfigurationProperties(prefix = PayConst.WECHATPAY_DEPOSIT_ACCOUNT)
public class DepositPayConfig extends WeChatPayConfig {

}
