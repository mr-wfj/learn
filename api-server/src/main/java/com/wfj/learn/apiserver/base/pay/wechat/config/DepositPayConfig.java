package com.wfj.learn.apiserver.base.pay.wechat.config;


import com.github.wxpay.sdk.WXPayConfig;
import com.wfj.learn.apiserver.base.pay.PayConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

/**
 * @Author: WFJ
 * @Date: 2019/5/7 17:00
 * @Description:
 */
@Component(PayConst.WECHATPAY_DEPOSIT_ACCOUNT_BEAN)
public abstract class DepositPayConfig extends WXPayConfig {

    @Autowired
    private Map<String, WeChatPayConfig> configs;

    private WeChatPayConfig config = configs.get(PayConst.WECHATPAY_DEPOSIT_ACCOUNT);

    /**
     * certPath
     */
    private String certPath = config.getCertPath();

    private byte[] certData;

    public DepositPayConfig() throws Exception {
        File file = new File(certPath);
        InputStream certStream = new FileInputStream(file);
        this.certData = new byte[(int) file.length()];
        certStream.read(this.certData);
        certStream.close();
    }

    /**
     * 获取 App ID
     *
     * @return App ID
     */
    public String getAppID() {
        return config.getAppId();
    }

    /**
     * 获取 Mch ID
     *
     * @return Mch ID
     */
    public String getMchID() {
        return config.getMchId();
    }

    /**
     * 获取 API 密钥
     *
     * @return API密钥
     */
    public String getKey() {
        return config.getAppKey();
    }

    /**
     * 获取商户证书内容
     *
     * @return 商户证书内容
     */
    public InputStream getCertStream() {
        ByteArrayInputStream iputStream = new ByteArrayInputStream(this.certData);
        return iputStream;
    }

}
