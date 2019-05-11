package com.wfj.learn.apiserver.base.pay.wechat;

import lombok.Data;

/**
 * @Author: WFJ
 * @Date: 2019/5/7 16:07
 * @Description:
 */
@Data
public class WeChatNotify {

    /**
     * 返回状态码:SUCCESS
     */
    private String return_code;

    /**
     * 返回信息:OK
     */
    private String return_msg;

    /**
     * 受理商户的APPID
     */
    private String appid;
    /**
     * 受理商户的商户号
     */
    private String mch_id;
    /**
     * 子商户在微信开放平台上申请的APPID
     */
    private String sub_appid;
    /**
     * 子商户的商户号
     */
    private String sub_mch_id;
    /**
     * 微信支付分配的终端设备号，
     */
    private String device_info;
    /**
     * 随机字符串，不长于32位
     */
    private String nonce_str;
    /**
     * 签名，详见签名算法
     */
    private String sign;
    /**
     * 业务结果:SUCCESS/FAIL
     */
    private String result_code;
    /**
     * 错误代码
     */
    private String err_code;
    /**
     * 错误代码描述
     */
    private String err_code_des;
    /**
     * 用户在商户appid下的唯一标识
     */
    private String openid;
    /**
     * 用户是否关注公众账号，Y-关注，N-未关注（机构商户不返回）
     */
    private String is_subscribe;
    /**
     * 用户是否关注子公众账号，Y-关注，N-未关注（机构商户不返回）
     */
    private String sub_is_subscribe;
    /**
     * 交易类型:APP
     */
    private String trade_type;
    /**
     * 付款银行,银行类型，采用字符串类型的银行标识，银行类型见银行列表
     */
    private String bank_type;
    /**
     * 订单总金额，单位为分
     */
    private String total_fee;
    /**
     * 货币类型，符合ISO4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     */
    private String fee_type;
    /**
     * 现金支付金额订单现金支付金额，详见支付金额
     */
    private String cash_fee;
    /**
     * 货币类型，符合ISO4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     */
    private String cash_fee_type;
    /**
     * 微信支付订单号
     */
    private String transaction_id;
    /**
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
     */
    private String out_trade_no;
    /**
     * 商家数据包，原样返回
     */
    private String attach;
    /**
     * 支付完成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
     */
    private String time_end;


}
