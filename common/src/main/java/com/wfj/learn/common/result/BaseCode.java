package com.wfj.learn.common.result;

public enum BaseCode implements Code {
    /**
     * 200:成功
     */
    SUCCESS(200, "成功"),

    /**
     * 201:参数或者语法不对
     */
    BAD_REQUEST(201, "参数或者语法不对"),

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

    BaseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return 0;
    }

    @Override
    public String getMsg() {
        return null;
    }
}
