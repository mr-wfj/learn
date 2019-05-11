package com.wfj.learn.apiserver.base.pay.ali;

import lombok.Data;

import java.util.Date;

/**
 * @Author: WFJ
 * @Date: 2019/5/7 10:15
 * @Description:
 */
@Data
public class ALiNotify {

    //https://docs.open.alipay.com/204/105301/

    /**
     * 通知的发送时间。格式为yyyy-MM-dd HH:mm:ss
     */
    private Date notify_time;
    /**
     * 通知的类型:trade_status_sync
     */
    private String notify_type;
    /**
     * 通知校验ID
     */
    private String notify_id;
    /**
     * 支付宝分配给开发者的应用Id
     */
    private String app_id;
    /**
     * 编码格式，如utf-8、gbk、gb2312等
     */
    private String charset;
    /**
     * 调用的接口版本，固定为：1.0
     */
    private String version;
    /**
     * 商户生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2
     */
    private String sign_type;
    /**
     * 请参考异步返回结果的验签
     */
    private String sign;
    /**
     * 支付宝交易凭证号
     */
    private String trade_no;
    /**
     * 原支付请求的商户订单号
     */
    private String out_trade_no;
    /**
     * 商户业务ID，主要是退款通知中返回退款申请的流水号
     */
    private String out_biz_no;
    /**
     * 买家支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字
     */
    private String buyer_id;
    /**
     * 买家支付宝账号
     */
    private String buyer_logon_id;
    /**
     * 卖家支付宝用户号
     */
    private String seller_id;
    /**
     * 卖家支付宝账号
     */
    private String seller_email;
    /**
     * 交易目前所处的状态，见交易状态说明
     */
    private String trade_status;
    /**
     * 本次交易支付的订单金额，单位为人民币（元）
     */
    private String total_amount;
    /**
     * 商家在交易中实际收到的款项，单位为元
     */
    private String receipt_amount;
    /**
     * 用户在交易中支付的可开发票的金额
     */
    private String invoice_amount;
    /**
     * 用户在交易中支付的金额
     */
    private String buyer_pay_amount;
    /**
     * 使用集分宝支付的金额
     */
    private String point_amount;
    /**
     * 退款通知中，返回总退款金额，单位为元，支持两位小数
     */
    private String refund_fee;
    /**
     * 商品的标题/交易标题/订单标题/订单关键字等，是请求时对应的参数，原样通知回来
     */
    private String subject;
    /**
     * 该订单的备注、描述、明细等。对应请求时的body参数，原样通知回来
     */
    private String body;
    /**
     * 该笔交易创建的时间。格式为yyyy-MM-dd HH:mm:ss
     */
    private String gmt_create;
    /**
     * 该笔交易的买家付款时间。格式为yyyy-MM-dd HH:mm:ss
     */
    private String gmt_payment;
    /**
     * 该笔交易的退款时间。格式为yyyy-MM-dd HH:mm:ss.S
     */
    private String gmt_refund;
    /**
     * 该笔交易结束时间。格式为yyyy-MM-dd HH:mm:ss
     */
    private String gmt_close;
    /**
     * 支付成功的各个渠道金额信息，详见资金明细信息说明
     */
    private String fund_bill_list;
    /**
     * 公共回传参数，如果请求时传递了该参数，则返回给商户时会在异步通知时将该参数原样返回。本参数必须进行UrlEncode之后才可以发送给支付宝
     */
    private String passback_params;
    /**
     * 本交易支付时所使用的所有优惠券信息，详见优惠券信息说明
     */
    private String voucher_detail_list;

}
