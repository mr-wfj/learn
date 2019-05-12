package com.wfj.learn.apiserver.base.pay.wechat;


import com.wfj.learn.apiserver.base.exception.CustomException;
import com.wfj.learn.apiserver.base.order.Order;
import com.wfj.learn.apiserver.base.order.OrderTypeEnum;
import com.wfj.learn.apiserver.base.order.OrderVO;
import com.wfj.learn.apiserver.base.pay.BasePay;
import com.wfj.learn.apiserver.base.pay.PayConst;
import com.wfj.learn.apiserver.base.pay.wechat.config.WeChatPayConfig;
import com.wfj.learn.apiserver.base.pay.wechat.sdk.WXPay;
import com.wfj.learn.apiserver.base.pay.wechat.sdk.WXPayConfig;
import com.wfj.learn.apiserver.base.result.ResultCode;
import com.wfj.learn.apiserver.base.result.ResultJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: WFJ
 * @Date: 2019/4/28 15:42
 * @Description: 微信支付实现
 */
@Component("wechat")
public class WeChatPay implements BasePay {

    private Logger logger = LoggerFactory.getLogger(WeChatPay.class);


    @Autowired
    private Map<String, WXPayConfig> payConfigs = new ConcurrentHashMap<>();

    @Autowired
    private Map<String, WeChatPayConfig> configs = new ConcurrentHashMap<>();

    /**
     * 支付-发起支付订单
     *
     * @param order 订单
     * @return OrderVO
     */
    @Override
    public OrderVO pay(Order order) {

        WeChatPayConfig config = configs.get(PayConst.WECHATPAY_DEFAULT_ACCOUNT);
        WXPayConfig payConfig = payConfigs.get(PayConst.WECHATPAY_DEFAULT_ACCOUNT_BEAN);

        if (OrderTypeEnum.deposit_recharge.getCode().equals(order.getType())) {//押金
            config = configs.get(PayConst.WECHATPAY_DEPOSIT_ACCOUNT);
            payConfig = payConfigs.get(PayConst.WECHATPAY_DEPOSIT_ACCOUNT);
        }

        WXPay wxpay = null;
        try {
            wxpay = new WXPay(payConfig);
        } catch (Exception e) {
            logger.error("微信支付统一下单失败", e);
            throw new CustomException(ResultJson.failure(ResultCode.ORDER_FAILURE));
        }

        Map<String, String> data = new HashMap<>();

        //商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一。详见商户订单号
        data.put("out_trade_no", order.getNumber());
        //订单总金额，单位为分，详见支付金额
        data.put("total_fee", String.valueOf(order.getAmount() * 1000));
        //终端IP,支持IPV4和IPV6两种格式的IP地址。调用微信支付API的机器IP
        data.put("spbill_create_ip", "123.12.12.123");
        //通知地址,接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。
        data.put("notify_url", config.getNotifyUrl());
        //交易类型,支付类型
        data.put("trade_type", "APP");
        data.put("body", order.getDescription());


        String payTradeNumber = null;
        try {
            Map<String, String> resp = wxpay.unifiedOrder(data);
            //logger.error("微信支付统一下单结果:{}", resp);

            //return_code 和result_code都为SUCCESS
            if (resp.get("return_code").equals("SUCCESS") && resp.get("result_code").equals("SUCCESS")) {
                //微信生成的预支付回话标识，用于后续接口调用中使用，该值有效期为2小时
                payTradeNumber = resp.get("prepay_id");
            } else {
                logger.error("微信支付统一下单失败:{}", resp);
                throw new CustomException(ResultJson.failure(ResultCode.ORDER_FAILURE));
            }
        } catch (Exception e) {
            logger.error("微信支付统一下单失败", e);
            throw new CustomException(ResultJson.failure(ResultCode.ORDER_FAILURE));
        }

        return OrderVO.builder().payTradeNumber(payTradeNumber).orderNumber(order.getNumber()).build();
    }

}
