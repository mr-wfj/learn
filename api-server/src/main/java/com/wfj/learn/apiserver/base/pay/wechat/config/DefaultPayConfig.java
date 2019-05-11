package com.wfj.learn.apiserver.base.pay.wechat.config;

import com.github.wxpay.sdk.WXPayConfig;
import com.wfj.learn.apiserver.base.pay.PayConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Map;

/**
 * @Author: WFJ
 * @Date: 2019/5/7 17:00
 * @Description:
 */
@Component(PayConst.WECHATPAY_DEFAULT_ACCOUNT)
@ConfigurationProperties(prefix = PayConst.WECHATPAY_DEFAULT_ACCOUNT)
public abstract class DefaultPayConfig extends WXPayConfig {

    @Autowired
    private Map<String, WeChatPayConfig> configs;

    private WeChatPayConfig config = configs.get(PayConst.WECHATPAY_DEPOSIT_ACCOUNT);


    public String getAppID() {
        return config.getAppID();
    }

    public String getMchID() {
        return config.getMchID();
    }


    public String getKey() {
        return config.getKey();
    }

    /**
     * 获取商户证书内容
     *
     * @return 商户证书内容
     */
    public InputStream getCertStream() {
        File file = new File(config.getCertPath());

        byte[] certData = new byte[200];
        if (file.exists()) {

            InputStream certStream = null;
            try {
                certStream = new FileInputStream(file);
                certData = new byte[(int) file.length()];
                certStream.read(certData);
                certStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ByteArrayInputStream iputStream = new ByteArrayInputStream(certData);
        return iputStream;
    }


}
