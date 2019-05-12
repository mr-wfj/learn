package com.wfj.learn.apiserver.base.pay.wechat.config;

import lombok.Data;

/**
 * @Author: WFJ
 * @Date: 2019/5/6 10:28
 * @Description:
 */
@Data
public class WeChatPayConfig {

    /**
     * appID
     */
    private String appId;

    /**
     * mchID
     */
    private String mchId;

    /**
     * key
     */
    private String appKey;

    /**
     * certPath
     */
    private String certPath;
    /**
     * notifyUrl
     */
    private String notifyUrl;
    /**
     * serverUrl
     */
    private String serverUrl;
}
