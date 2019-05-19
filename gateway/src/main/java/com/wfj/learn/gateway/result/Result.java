package com.wfj.learn.gateway.result;

import lombok.Data;

/**
 * @author WFJ
 * RESTful API 返回类型
 */
@Data
public class Result<T> {

    private int code;
    private String message;
    private T data;

    public static Result ok() {
        return ok("");
    }

    public static Result ok(Object o) {
        return new Result(ResultCode.SUCCESS, o);
    }

    public static Result failure(ResultCode code) {
        return failure(code, "");
    }

    public static Result failure(ResultCode code, Object o) {
        return new Result(code, o);
    }

    public Result(ResultCode resultCode) {
        setResultCode(resultCode);
    }

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(ResultCode resultCode, T data) {
        setResultCode(resultCode);
        this.data = data;
    }

    public void setResultCode(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMsg();
    }

    /**
     * 是否成功
     *
     * @return boolean
     */
    public boolean isSuccess() {
        return ResultCode.SUCCESS.getCode() == this.code;
    }

    @Override
    public String toString() {
        return "{" +
                "\"code\":" + code +
                ", \"message\":\"" + message + '\"' +
                ", \"data\":\"" + data + '\"' +
                '}';
    }
}
