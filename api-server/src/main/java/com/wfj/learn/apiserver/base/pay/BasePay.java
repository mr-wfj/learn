package com.wfj.learn.apiserver.base.pay;

import com.wfj.learn.apiserver.base.order.PayOrder;
import com.wfj.learn.apiserver.base.order.OrderVO;
import org.springframework.stereotype.Component;

/**
 * @Author: WFJ
 * @Date: 2019/4/28 15:37
 * @Description: 支付基类
 */
@Component
public interface BasePay {

    /**
     * 支付-发起支付订单
     *
     * @param payOrder 订单
     * @return OrderVO
     */
    OrderVO pay(PayOrder payOrder);

}
