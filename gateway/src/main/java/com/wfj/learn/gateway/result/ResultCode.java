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
     * 202:非法的请求
     */
    ILLEGAL_REQUEST(202, "非法的请求"),
    /**
     * 203:重复提交
     */
    REPEATED_SUBMIT(203, "重复提交"),
    /**
     * 204:支付类型错误
     */
    PAY_TYPE_BAD(204, "支付类型错误"),


    /**
     * 210:认证失败
     */
    UNAUTHORIZED(210, "认证失败"),
    /**
     * 211:登录超时
     */
    TOKEN_TIME_OUT(211, "登录超时"),
    /**
     * 212:其他设备登录
     */
    OTHER_DEVICE_LOGIN(212, "您的账号已在其他设备登录"),

    /**
     * 302:登陆失败，用户名或密码无效
     */
    LOGIN_ERROR(302, "登陆失败，用户名或密码无效"),
    /**
     * 303:用户名无效
     */
    USERNAME_INVALID(303, "用户名无效"),
    /**
     * 304:用户名已注册
     */
    USERNAME_EXISTED(304, "用户名已注册"),
    /**
     * 305:手机号已注册
     */
    MOBILE_EXISTED(305, "手机号已注册"),
    /**
     * 306:手机号错误
     */
    MOBILE_ERROR(306, "手机号错误"),
    /**
     * 306:手机号未注册
     */
    MOBILE_NOT_FOUND(307, "手机号未注册"),
    /**
     * 308:用户名不存在
     */
    ACCOUNT_NOT_EXIST(308, "用户名/手机号未注册"),
    /**
     * 309:密码错误
     */
    PASSWORD_ERROR(309, "密码错误"),
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
     * 315:原密码错误
     */
    OLD_PASSWORD_ERROR(315, "原密码错误"),
    /**
     * 303:昵称无效
     */
    NICKNAME_INVALID(315, "昵称无效"),

    /**
     * 320:支付密码错误
     */
    PAY_PASSWORD_FAILURE(320, "支付密码错误"),
    /**
     * 321:未设置支付密码
     */
    PAY_PASSWORD_NOT(321, "未设置支付密码"),
    /**
     * 322:原支付密码错误
     */
    OLD_PAY_PASSWORD_FAILURE(322, "原支付密码错误"),
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
     * 327:未充值佣金
     */
    DEPOSIT_NOT_FOUND(327, "未充值佣金"),
    /**
     * 328:佣金退款已提交,请勿重复提交
     */
    DEPOSIT_SUBMIT(328, "佣金退款已提交,请勿重复提交"),
    /**
     * 329:有余额提现未完成,请耐心等待
     */
    WALLET_WITHDRAW_SUBMIT(329, "有余额提现未完成,请耐心等待"),
    /**
     * 330:超过单笔提现最大额度
     */
    exceed_MAX_AMOUNT(330, "超过单笔提现最大额度"),
    /**
     * 账户已绑定
     */
    Account_is_bound(331, "账户已绑定"),

    /**
     * 330:无足够的余额或洗车券,无法打开洗车机车位锁
     */
    NO_OPEN_PARKING_LOCK(340, "无足够的余额或洗车券,无法打开洗车机车位锁"),
    /**
     * 331:设备不存在
     */
    NO_DEVICE(341, "设备不存在"),
    /**
     * 332:设备使用中
     */
    DEVICE_USEING(342, "设备使用中,若无人使用,请联系客服解决"),
    /**
     * 333:设备暂停使用
     */
    DEVICE_ERROR(343, "设备异常暂停使用,请联系客服解决"),
    /**
     * 334:没有洗车券
     */
    TICKET_NOT_FOUND(345, "没有洗车券"),
    /**
     * 335:打开车位锁失败
     */
    OPEN_PARKINGLOCK_FAILURE(346, "打开车位锁失败"),

    /**
     * 340:订单不存在
     */
    ORDER_NOT_FOUND(350, "订单不存在"),
    /**
     * 341:订单错误
     */
    ORDER_ERROR(351, "订单错误"),

    /**
     * 342:支付下单失败
     */
    ORDER_FAILURE(352, "下单失败"),
    /**
     * 343:订单已关闭
     */
    ORDER_CLOSE(353, "订单已关闭"),
    /**
     * 344:订单未支付
     */
    ORDER_NO_PAY(354, "订单未支付"),
    /**
     * 345:订单已创建,请勿重复添加,请去支付
     */
    ORDER_created(355, "订单已创建,请勿重复添加,请去支付"),
    /**
     * 345:订单已支付
     */
    ORDER_PAID(355, "订单已支付"),

    /**
     * 360:兑换码不存在
     */
    INVITATION_CODE_NOT_FOUND(360, "邀请码不存在"),

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
     * 409:上传失败
     */
    UPLOAD_FILE_FAIL_CODE(409, "上传失败"),

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

    /**
     * 创建 Code
     *
     * @return Code
     */
    public Code build() {
        return new Code() {
            @Override
            public int getCode() {
                return code;
            }

            @Override
            public String getMsg() {
                return msg;
            }
        };
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
