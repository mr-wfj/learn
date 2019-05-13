package com.wfj.learn.apiserver.base.pay.wallet;

import com.wfj.learn.apiserver.base.order.Order;
import com.wfj.learn.apiserver.base.pay.BasePay;
import com.wfj.learn.apiserver.base.order.OrderVO;
import com.wfj.learn.apiserver.base.pay.PayConst;
import org.springframework.stereotype.Component;

/**
 * @Author: WFJ
 * @Date: 2019/4/28 15:42
 * @Description: 钱包支付实现
 */
@Component(PayConst.WALLET_PAY)
public class WalletPay implements BasePay {


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
