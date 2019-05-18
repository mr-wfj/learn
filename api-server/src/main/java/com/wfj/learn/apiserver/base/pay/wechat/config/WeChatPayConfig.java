package com.wfj.learn.apiserver.base.pay.wechat.config;

import com.wfj.learn.apiserver.base.pay.wechat.sdk.*;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: WFJ
 * @Date: 2019/5/6 10:28
 * @Description:
 */
@Data
public class WeChatPayConfig extends WXPayConfig {

    private Logger logger = LoggerFactory.getLogger(WeChatPayConfig.class);


    /**
     * appID
     */
    private String apiAppId;

    /**
     * mchID
     */
    private String apiMchId;

    /**
     * API key
     */
    private String apiKey;

    /**
     * certPath
     */
    private String certPath;
    /**
     * notifyUrl
     */
    private String notifyUrl;

    /**
     * useSandbox 沙箱环境
     */
    private boolean useSandbox;

    /**
     * 获取 App ID
     *
     * @return App ID
     */
    @Override
    public String getAppID() {
        return apiAppId;
    }

    /**
     * 获取 Mch ID
     *
     * @return Mch ID
     */
    @Override
    public String getMchID() {
        return apiMchId;
    }

    /**
     * 获取 API 密钥
     *
     * @return API密钥
     */
    @Override
    public String getKey() {
        return apiKey;
    }

    /**
     * 获取商户证书内容
     *
     * @return 商户证书内容
     */
    @Override
    public InputStream getCertStream() throws IOException {
        File file = new File(certPath);
        InputStream certStream = new FileInputStream(file);
        byte[] certData = new byte[(int) file.length()];
        certStream.read(certData);
        certStream.close();
        return new ByteArrayInputStream(certData);
    }

    /**
     * 获取WXPayDomain, 用于多域名容灾自动切换
     *
     * @return
     */
    @Override
    public IWXPayDomain getWXPayDomain() {
        IWXPayDomain iwxPayDomain = new IWXPayDomain() {
            @Override
            public void report(String domain, long elapsedTimeMillis, Exception ex) {
            }

            @Override
            public DomainInfo getDomain(WXPayConfig config) {
                return new IWXPayDomain.DomainInfo(WXPayConstants.DOMAIN_API, true);
            }
        };
        return iwxPayDomain;
    }

    /**
     * 设置沙漏环境keye
     *
     * @return boolean
     * @throws Exception e
     */
    public boolean setSandboxSignKey() throws Exception {
        try {
            WXPay wxPay = new WXPay(this);

            Map<String, String> params = new HashMap<>();
            params.put("mch_id", this.getMchID());
            params.put("nonce_str", WXPayUtil.generateNonceStr());
            params.put("sign", WXPayUtil.generateSignature(params, this.getKey()));
            String strXML = wxPay.requestWithoutCert("/sandboxnew/pay/getsignkey",
                    params, this.getHttpConnectTimeoutMs(), this.getHttpReadTimeoutMs());

            Map<String, String> result = WXPayUtil.xmlToMap(strXML);
            logger.debug("retrieveSandboxSignKey{}", result);

            if ("SUCCESS".equals(result.get("return_code"))) {
                apiKey = result.get("sandbox_signkey");
                return true;

            }
            return false;
        } catch (Exception e) {
            throw e;
        }
    }


}
