package com.wfj.learn.gateway.result;

/**
 * @author WFJ
 * 状态码
 */
public enum ResultCode {
    /*
    请求返回状态码和说明信息
     */

    /**
     * 200:成功
     */
    SUCCESS(200, "成功"),

    /**
     * 201:参数或者语法不对
     */
    BAD_REQUEST(201, "参数或者语法不对"),
    /**
     * 202:重复提交
     */
    REPEATED_SUBMIT(202, "重复提交"),
    /**
     * 203:支付类型错误
     */
    PAY_TYPE_BAD(203, "支付类型错误"),


    /**
     * 301:认证失败
     */
    UNAUTHORIZED(301, "认证失败"),
    /**
     * 302:登陆失败，用户名或密码无效
     */
    LOGIN_ERROR(302, "登陆失败，用户名或密码无效"),
    /**
     * 303:用户已存在
     */
    USER_EXISTED(303, "用户已存在"),

    /**
     * 310:验证码发送失败
     */
    VERIFY_CODE_SEND_FAILURE(310, "验证码发送失败"),
    /**
     * 311:验证码错误
     */
    VERIFY_CODE_FAILURE(311, "验证码错误"),
    /**
     * 312:验证码超时
     */
    VERIFY_CODE_TIME_OUT(312, "验证码超时"),
    /**
     * 313:未获取验证码,请重新获取验证码
     */
    VERIFY_CODE_NOT(313, "未获取验证码,请重新获取验证码"),
    /**
     * 314:验证码已发送,请勿重复获取验证码
     */
    VERIFY_CODE_SEND(314, "验证码已发送,请勿重复获取验证码"),


    /**
     * 320:支付密码错误
     */
    PAY_PASSWORD_FAILURE(320, "支付密码错误"),
    /**
     * 321:未设置支付密码
     */
    PAY_PASSWORD_NOT(321, "未设置支付密码"),
    /**
     * 322:重置支付密码失败
     */
    RESET_PAY_PASSWORD_NOT(322, "重置支付密码失败"),
    /**
     * 323:超过支付密码错误次数
     */
    PAY_PASSWORD_LOCKED(323, "超过支付密码错误次数"),
    /**
     * 324:余额不足
     */
    BALANCE_INSUFFICIENT(324, "余额不足"),
    /**
     * 325:交易不存在
     */
    TRADE_NOT_FOUND(325, "交易不存在"),
    /**
     * 326:交易已关闭:已支付或已取消
     */
    TRADE_CLOSE(326, "交易已关闭"),

    /**
     * 330:无足够的余额或洗车券,无法打开洗车机车位锁
     */
    NO_OPEN_PARKING_LOCK(330, "无足够的余额或洗车券,无法打开洗车机车位锁"),
    /**
     * 331:设备不存在
     */
    NO_DEVICE(331, "设备不存在"),
    /**
     * 332:设备使用中
     */
    DEVICE_USEING(332, "设备使用中,若无人使用,请联系客服解决"),
    /**
     * 333:设备暂停使用
     */
    DEVICE_ERROR(333, "设备异常暂停使用,请联系客服解决"),
    /**
     * 334:没有洗车券
     */
    TICKET_NOT_FOUND(334, "没有洗车券"),
    /**
     * 335:打开车位锁失败
     */
    OPEN_PARKINGLOCK_FAILURE(335, "打开车位锁失败"),

    /**
     * 340:订单不存在
     */
    ORDER_NOT_FOUND(340, "订单不存在"),
    /**
     * 341:订单错误
     */
    ORDER_ERROR(341, "订单错误"),

    /**
     * 342:支付下单失败
     */
    ORDER_FAILURE(342, "下单失败"),
    /**
     * 343:订单已关闭
     */
    ORDER_CLOSE(343, "订单已关闭"),
    /**
     * 344:订单未支付
     */
    ORDER_NO_PAY(344, "订单未支付"),


    /**
     * 403:禁止访问
     */
    FORBIDDEN(403, "禁止访问"),
    /**
     * 404:请求的资源不存在
     */
    NOT_FOUND(404, "请求的资源不存在"),
    /**
     * 405:操作失败，请求操作的资源不存在
     */
    OPERATE_ERROR(405, "操作失败，请求操作的资源不存在"),
    /**
     * 408:请求超时
     */
    TIME_OUT(408, "请求超时"),


    /**
     * 500:服务器内部错误
     */
    SERVER_ERROR(500, "服务器内部错误");


    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
