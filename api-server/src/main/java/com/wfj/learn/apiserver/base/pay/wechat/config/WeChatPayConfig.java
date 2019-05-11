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
    private String appID;

    /**
     * mchID
     */
    private String mchID;

    /**
     * key
     */
    private String key;

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
