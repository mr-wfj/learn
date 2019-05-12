package com.wfj.learn.apiserver.base.pay;

/**
 * @Author: WFJ
 * @Date: 2019/4/28 11:11
 * @Description: 支付-常量
 */
public final class PayConst {
    private PayConst() {
    }


    /**
     * 支付宝-默认账户
     */
    public final static String ALIPAY_DEFAULT_ACCOUNT = "alipay.default";
    /**
     * 支付宝-押金账户
     */
    public final static String ALIPAY_DEPOSIT_ACCOUNT = "alipay.deposit";
    /**
     * 微信-默认账户
     */
    public final static String WECHATPAY_DEFAULT_ACCOUNT = "wecahtpay.default";
    /**
     * 微信-押金账户
     */
    public final static String WECHATPAY_DEPOSIT_ACCOUNT = "wecahtpay.deposit";

    /**
     * 微信-默认账户
     */
    public final static String WECHATPAY_DEFAULT_ACCOUNT_BEAN = "wecahtpay.default.bean";
    /**
     * 微信-押金账户
     */
    public final static String WECHATPAY_DEPOSIT_ACCOUNT_BEAN = "wecahtpay.deposit.bean";

    /**
     * 银联-默认账户
     */
    public final static String UNIONPAY_DEFAULT_ACCOUNT = "unionpay.default";

    /**
     * 银联-押金账户
     */
    public final static String UNIONPAY_DEPOSIT_ACCOUNT = "unionpay.deposit";
}
