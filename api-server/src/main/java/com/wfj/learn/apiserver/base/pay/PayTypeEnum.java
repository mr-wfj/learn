package com.wfj.learn.apiserver.base.pay;

/**
 * 支付类型
 */
public enum PayTypeEnum {

    /**
     * 钱包
     */
    WALLET_PAY("wallet_pay", "钱包"),

    /**
     * 支付宝
     */
    ALI_PAY("ali_pay", "支付宝"),

    /**
     * 微信
     */
    WECHAT_PAY("wechat_pay", "微信"),

    /**
     * 银联
     */
    UNION_PAY("union_pay", "银联");

    private String code;
    private String name;

    PayTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
