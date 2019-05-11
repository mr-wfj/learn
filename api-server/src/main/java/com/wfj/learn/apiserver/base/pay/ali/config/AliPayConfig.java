package com.wfj.learn.apiserver.base.pay.ali.config;

import lombok.Data;

/**
 * @Author: WFJ
 * @Date: 2019/4/30 15:43
 * @Description:
 */
@Data
public class AliPayConfig {


    private String appId;
    private String appPrivateKey;
    private String charset;
    private String alipayPublicKey;
    private String notifyUrl;
    private String serverUrl;

}
