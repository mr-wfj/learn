package com.wfj.learn.apiserver.base.pay.union;

import com.wfj.learn.apiserver.base.order.PayOrder;
import com.wfj.learn.apiserver.base.order.OrderVO;
import com.wfj.learn.apiserver.base.pay.BasePay;
import com.wfj.learn.apiserver.base.pay.PayConst;
import org.springframework.stereotype.Component;

/**
 * @Author: WFJ
 * @Date: 2019/4/29 11:52
 * @Description: 银联支付
 */
@Component(PayConst.UNION_PAY)
public class UnionPay implements BasePay {

    /**
     * 支付-发起支付订单
     *
     * @param payOrder 订单
     * @return OrderVO
     */
    @Override
    public OrderVO pay(PayOrder payOrder) {
        return OrderVO.builder().orderNumber(payOrder.getNumber()).build();
    }

}
