package com.wfj.learn.apiserver.base.pay.ali.config;

/**
 * @Author: WFJ
 * @Date: 2019/4/30 15:43
 * @Description:
 */
public class DepositConfig implements AliPayConfig {

    private String appId;
    private String appPrivateKey;
    private String charset;
    private String alipayPublicKey;
    private String notifyUrl;
    private String serverUrl;

    @Override
    public String getId() {
        return appId;
    }

}
