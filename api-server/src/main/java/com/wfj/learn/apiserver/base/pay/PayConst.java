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
     * 钱包
     */
    public static final String WALLET_PAY = "wallet_pay";

    /**
     * 支付宝
     */
    public static final String ALI_PAY = "ali_pay";

    /**
     * 微信
     */
    public static final String WECHAT_PAY = "wechat_pay";

    /**
     * 银联
     */
    public static final String UNION_PAY = "union_pay";


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
    public final static String WECHATPAY_DEFAULT_ACCOUNT = "wechatpay.default";
    /**
     * 微信-押金账户
     */
    public final static String WECHATPAY_DEPOSIT_ACCOUNT = "wechatpay.deposit";

    /**
     * 微信-默认账户
     */
    public final static String WECHATPAY_DEFAULT_ACCOUNT_BEAN = "wechatpay.default.bean";
    /**
     * 微信-押金账户
     */
    public final static String WECHATPAY_DEPOSIT_ACCOUNT_BEAN = "wechatpay.deposit.bean";

    /**
     * 银联-默认账户
     */
    public final static String UNIONPAY_DEFAULT_ACCOUNT = "unionpay.default";

    /**
     * 银联-押金账户
     */
    public final static String UNIONPAY_DEPOSIT_ACCOUNT = "unionpay.deposit";
}
