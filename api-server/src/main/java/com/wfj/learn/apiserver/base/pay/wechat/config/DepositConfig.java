package com.wfj.learn.apiserver.base.pay.wechat.config;


import com.wfj.learn.apiserver.base.pay.PayConst;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: WFJ
 * @Date: 2019/4/30 15:43
 * @Description:
 */
@Component(PayConst.WECHATPAY_DEPOSIT_ACCOUNT)
@ConfigurationProperties(prefix = PayConst.WECHATPAY_DEPOSIT_ACCOUNT)
public class DepositConfig extends WeChatPayConfig {


}
