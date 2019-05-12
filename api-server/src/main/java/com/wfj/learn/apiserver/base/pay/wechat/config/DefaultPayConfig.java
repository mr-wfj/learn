package com.wfj.learn.apiserver.base.pay.wechat.config;

import com.wfj.learn.apiserver.base.pay.PayConst;
import com.wfj.learn.apiserver.base.pay.wechat.sdk.IWXPayDomain;
import com.wfj.learn.apiserver.base.pay.wechat.sdk.WXPayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Map;

/**
 * @Author: WFJ
 * @Date: 2019/5/7 17:00
 * @Description:
 */
@Component(PayConst.WECHATPAY_DEFAULT_ACCOUNT_BEAN)
public class DefaultPayConfig extends WXPayConfig {

    @Autowired
    private Map<String, WeChatPayConfig> configs;

    @Override
    public String getAppID() {
        return configs.get(PayConst.WECHATPAY_DEFAULT_ACCOUNT_BEAN).getAppId();
    }

    @Override
    public String getMchID() {
        return configs.get(PayConst.WECHATPAY_DEFAULT_ACCOUNT_BEAN).getMchId();
    }

    @Override
    public String getKey() {
        return configs.get(PayConst.WECHATPAY_DEFAULT_ACCOUNT_BEAN).getAppKey();
    }

    /**
     * 获取商户证书内容
     *
     * @return 商户证书内容
     */
    @Override
    public InputStream getCertStream() {
        File file = new File(configs.get(PayConst.WECHATPAY_DEFAULT_ACCOUNT_BEAN).getCertPath());

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

    @Override
    public IWXPayDomain getWXPayDomain() {
        return null;
    }


}
