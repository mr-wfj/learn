package com.wfj.learn.apiserver.base.pay.wechat;


import com.wfj.learn.apiserver.base.exception.CustomException;
import com.wfj.learn.apiserver.base.order.OrderTypeEnum;
import com.wfj.learn.apiserver.base.order.OrderVO;
import com.wfj.learn.apiserver.base.order.PayOrder;
import com.wfj.learn.apiserver.base.pay.BasePay;
import com.wfj.learn.apiserver.base.pay.PayConst;
import com.wfj.learn.apiserver.base.pay.wechat.config.WeChatPayConfig;
import com.wfj.learn.apiserver.base.pay.wechat.sdk.WXPay;
import com.wfj.learn.apiserver.base.result.Result;
import com.wfj.learn.apiserver.base.result.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: WFJ
 * @Date: 2019/4/28 15:42
 * @Description: 微信支付实现
 */
@Component(PayConst.WECHAT_PAY)
public class WeChatPay implements BasePay {

    private Logger logger = LoggerFactory.getLogger(WeChatPay.class);

    @Autowired
    private Map<String, WeChatPayConfig> payConfigs = new ConcurrentHashMap<>();

    /**
     * 支付-发起支付订单
     *
     * @param payOrder 订单
     * @return OrderVO
     */
    @Override
    public OrderVO pay(PayOrder payOrder) {

        logger.info("WeChatPay:OrderPay:{},date:{}", payOrder, new Date().toString());

        WeChatPayConfig payConfig = payConfigs.get(PayConst.WECHATPAY_DEFAULT_ACCOUNT);

        if (OrderTypeEnum.DEPOSIT_RECHARGE.getCode().equals(payOrder.getType())) {//押金
            payConfig = payConfigs.get(PayConst.WECHATPAY_DEPOSIT_ACCOUNT);
        }

        logger.debug("WeChatPayConfig:{}", payConfig);

        WXPay wxpay = null;
        try {
            wxpay = new WXPay(payConfig, payConfig.getNotifyUrl(), true, payConfig.isUseSandbox());
        } catch (Exception e) {
            logger.error("微信支付统一下单失败", e);
            throw new CustomException(Result.failure(ResultCode.ORDER_FAILURE));
        }

        Map<String, String> data = new HashMap<>();

        //商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一。详见商户订单号
        data.put("out_trade_no", payOrder.getNumber());
        //订单总金额，单位为分，详见支付金额
        data.put("total_fee", String.valueOf((int) payOrder.getAmount() * 100));
        //终端IP,支持IPV4和IPV6两种格式的IP地址。调用微信支付API的机器IP
        data.put("spbill_create_ip", "123.12.12.123");
        //通知地址,接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。
        data.put("notify_url", payConfig.getNotifyUrl());
        //交易类型,支付类型
        data.put("trade_type", "APP");
        data.put("body", payOrder.getDescription());

        //沙箱环境,设置沙箱环境key
        if (payConfig.isUseSandbox()) {
            try {
                payConfig.setSandboxSignKey();
                data.put("total_fee", "201");
            } catch (Exception e) {
                logger.error("获取sandbox_signkey异常", e);
                throw new CustomException(Result.failure(ResultCode.ORDER_FAILURE));
            }
        }

        String payTradeNumber = null;
        try {
            Map<String, String> resp = wxpay.unifiedOrder(data);
            //return_code 和result_code都为SUCCESS
            if ("SUCCESS".equals(resp.get("return_code")) && "SUCCESS".equals(resp.get("result_code"))) {
                //微信生成的预支付回话标识，用于后续接口调用中使用，该值有效期为2小时
                payTradeNumber = resp.get("prepay_id");
                logger.info("微信支付统一下单成功:{}", resp);
            } else {
                logger.error("微信支付统一下单失败:{}", resp);
                throw new CustomException(Result.failure(ResultCode.ORDER_FAILURE));
            }
        } catch (Exception e) {
            logger.error("微信支付统一下单异常", e);
            throw new CustomException(Result.failure(ResultCode.ORDER_FAILURE));
        }

        return OrderVO.builder().tradeNumber(payTradeNumber).orderNumber(payOrder.getNumber()).build();
    }

}
