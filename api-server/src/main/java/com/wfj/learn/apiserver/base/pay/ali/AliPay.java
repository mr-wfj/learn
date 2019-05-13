package com.wfj.learn.apiserver.base.pay.ali;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.wfj.learn.apiserver.base.exception.CustomException;
import com.wfj.learn.apiserver.base.order.Order;
import com.wfj.learn.apiserver.base.order.OrderTypeEnum;
import com.wfj.learn.apiserver.base.order.OrderVO;
import com.wfj.learn.apiserver.base.pay.BasePay;
import com.wfj.learn.apiserver.base.pay.PayConst;
import com.wfj.learn.apiserver.base.pay.ali.config.AliPayConfig;
import com.wfj.learn.apiserver.base.result.ResultCode;
import com.wfj.learn.apiserver.base.result.ResultJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URLDecoder;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: WFJ
 * @Date: 2019/4/28 15:40
 * @Description: 支付宝支付实现
 */
@Component("ali")
public class AliPay implements BasePay {

    private Logger logger = LoggerFactory.getLogger(AliPay.class);

    @Autowired
    private Map<String, AliPayConfig> payConfigs = new ConcurrentHashMap<>();


    /**
     * 支付-发起支付订单
     *
     * @param order 订单
     * @return OrderVO
     */
    @Override
    public OrderVO pay(Order order) {
        //API:https://docs.open.alipay.com/api_1/alipay.trade.create/

        logger.info("AliPay:orderNumber:{},date:{}", order.getNumber(), new Date().toString());

        AliPayConfig aliConfig = payConfigs.get(PayConst.ALIPAY_DEFAULT_ACCOUNT);

        if (OrderTypeEnum.deposit_recharge.getCode().equals(order.getType())) {//押金
            aliConfig = payConfigs.get(PayConst.ALIPAY_DEPOSIT_ACCOUNT);
        }

        //实例化客户端
        AlipayClient alipayClient = new DefaultAlipayClient(aliConfig.getServerUrl(), aliConfig.getAppId(), aliConfig.getAppPrivateKey(), "json", aliConfig.getCharset(), aliConfig.getAlipayPublicKey(), "RSA2");
        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();

        /**
         * 必选
         */
        //商户订单号,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复
        model.setOutTradeNo(order.getNumber());
        //订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
        //如果同时传入了【打折金额】，【不可打折金额】，【订单总金额】三者，则必须满足如下条件：【订单总金额】=【打折金额】+【不可打折金额】
        model.setTotalAmount(String.valueOf(order.getAmount()));
        //订单标题
        model.setSubject(order.getDescription());

        request.setBizModel(model);
        //回调地址:商户外网可以访问的异步地址
        request.setNotifyUrl(aliConfig.getNotifyUrl());

        String orderStr = null;
        try {
            //这里和普通的接口调用不同，使用的是sdkExecute
            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
            if (response.isSuccess()) {
                orderStr = response.getBody();
                String resultStr = URLDecoder.decode(orderStr, "UTF-8");
                logger.debug("支付宝支付统一下单成功:{}", resultStr);
            } else {
                logger.error("支付宝支付统一下单失败:{}", response);
                throw new CustomException(ResultJson.failure(ResultCode.ORDER_FAILURE, response.getSubMsg()));
            }
        } catch (Exception e) {
            logger.error("支付宝支付统一下单失败", e);
            throw new CustomException(ResultJson.failure(ResultCode.ORDER_FAILURE));
        }
        return OrderVO.builder().orderStr(orderStr).orderNumber(order.getNumber()).build();
    }

}
