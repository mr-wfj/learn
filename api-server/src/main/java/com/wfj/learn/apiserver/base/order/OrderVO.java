package com.wfj.learn.apiserver.base.order;

import lombok.Builder;
import lombok.Data;

/**
 * @Author: WFJ
 * @Date: 2019/4/28 11:18
 * @Description:
 */
@Data
@Builder
public class OrderVO {

    /**
     * 订单号
     */
    private String orderNumber;

    /**
     * 支付交易号(一般第三方支付都会产生)
     */
    private String tradeNumber;

    private String orderStr;

    
}
