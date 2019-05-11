package com.wfj.learn.apiserver.base.pay.ali;

/**
 * @Author: WFJ
 * @Date: 2019/5/7 11:00
 * @Description:
 */
public enum ALiEnum {

    /**
     * 交易创建，等待买家付款
     */
    WAIT_BUYER_PAY("WAIT_BUYER_PAY", "交易创建，等待买家付款"),

    /**
     * 未付款交易超时关闭，或支付完成后全额退款
     */
    TRADE_CLOSED("TRADE_CLOSED", "未付款交易超时关闭，或支付完成后全额退款"),

    /**
     * 交易支付成功
     */
    TRADE_SUCCESS("TRADE_SUCCESS", "交易支付成功"),

    /**
     * 交易结束，不可退款
     */
    TRADE_FINISHED("TRADE_FINISHED", "交易结束，不可退款");

    private String key;
    private String value;

    ALiEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }


    /**
     * 根据key获取value的值
     *
     * @param key String
     * @return String
     */
    public static String getValueByKey(String key) {
        for (ALiEnum s : ALiEnum.values()) {
            if (s.getKey().equals(key)) {
                return s.getValue();
            }
        }
        return "";
    }

}
