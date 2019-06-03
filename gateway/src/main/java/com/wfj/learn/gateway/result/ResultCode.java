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
