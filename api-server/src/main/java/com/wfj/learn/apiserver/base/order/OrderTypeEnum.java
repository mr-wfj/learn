package com.wfj.learn.apiserver.base.order;

/**
 * 订单类型
 */
public enum OrderTypeEnum {

    /**
     * 钱包充值
     */
    waller_recharge("waller_recharge", "钱包充值"),

    /**
     * 钱包提现
     */
    waller_withdrawal("waller_withdrawal", "钱包提现"),

    /**
     * 押金充值
     */
    deposit_recharge("deposit_recharge", "押金充值"),

    /**
     * 押金提现
     */
    deposit_withdrawal("deposit_withdrawal", "押金提现"),

    /**
     * 购买洗车券
     */
    buy_ticket("buy_ticket", "购买洗车券"),

    /**
     * 购买洗车服务
     */
    buy_wash_car("buy_wash_car", "购买洗车服务");


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
