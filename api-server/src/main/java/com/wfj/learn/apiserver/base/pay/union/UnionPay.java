package com.wfj.learn.apiserver.base.pay.union;

import com.wfj.learn.apiserver.base.order.Order;
import com.wfj.learn.apiserver.base.order.OrderVO;
import com.wfj.learn.apiserver.base.pay.BasePay;
import org.springframework.stereotype.Component;

/**
 * @Author: WFJ
 * @Date: 2019/4/29 11:52
 * @Description: 银联支付
 */
@Component("union")
public class UnionPay implements BasePay {

    /**
     * 支付-发起支付订单
     *
     * @param order 订单
     * @return OrderVO
     */
    @Override
    public OrderVO pay(Order order) {
        return OrderVO.builder().orderNumber(order.getNumber()).build();
    }

}
