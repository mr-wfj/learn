package com.wfj.learn.apiserver.base.order;

/**
 * 订单类型
 */
public enum OrderTypeEnum {

    /**
     * 钱包充值
     */
    WALLER_RECHARGE("waller_recharge", "钱包充值"),

    /**
     * 钱包提现
     */
    WALLER_WITHDRAWAL("waller_withdrawal", "钱包提现"),

    /**
     * 押金充值
     */
    DEPOSIT_RECHARGE("deposit_recharge", "押金充值"),

    /**
     * 押金提现
     */
    DEPOSIT_WITHDRAWAL("deposit_withdrawal", "押金提现"),

    /**
     * 购买洗车券
     */
    BUY_TICKET("buy_ticket", "购买洗车券"),

    /**
     * 购买洗车服务
     */
    BUY_WASH_CAR("buy_wash_car", "购买洗车服务");


    private String code;
    private String name;

    OrderTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
