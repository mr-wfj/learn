package com.wfj.learn.apiserver.base.pay.wechat.config;

import com.wfj.learn.apiserver.base.pay.wechat.sdk.IWXPayDomain;
import com.wfj.learn.apiserver.base.pay.wechat.sdk.WXPayConfig;

import java.io.*;

/**
 * @Author: WFJ
 * @Date: 2019/5/6 10:28
 * @Description:
 */
public class WeChatPayConfig extends WXPayConfig {

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

    @Override
    public String getAppID() {
        return appId;
    }

    @Override
    public String getMchID() {
        return mchId;
    }

    @Override
    public String getKey() {
        return appKey;
    }

    @Override
    public InputStream getCertStream() {
        File file = new File(certPath);
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


    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public void setCertPath(String certPath) {
        this.certPath = certPath;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }
}
