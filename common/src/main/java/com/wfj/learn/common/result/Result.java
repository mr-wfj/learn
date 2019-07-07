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
    private boolean success;

    public static Result ok() {
        return ok(null);
    }

    public static Result ok(Object o) {
        return new Result<>(ResultCode.SUCCESS.build(), o);
    }

    public static Result failure(Code code) {
        return new Result<>(code);
    }

    public static Result failure(Code code, Object o) {
        return new Result<>(code, o);
    }

    public static Result failureMsg(Code code, String msg) {
        return new Result<>(code, msg);
    }

    public Result(Code resultCode) {
        setResultCode(resultCode);
    }

    public Result(Code resultCode, T data) {
        setResultCode(resultCode);
        this.data = data;
    }

    public Result(Code resultCode, String msg) {
        setResultCode(resultCode);
        this.message = msg;
    }

    private void setResultCode(Code resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMsg();
        this.success = ResultCode.SUCCESS.getCode() == resultCode.getCode();
    }


    /**
     * 是否成功
     *
     * @return boolean
     */
    /*public boolean isSuccess() {
        return ResultCode.SUCCESS.getCode() == this.code;
    }*/
    @Override
    public String toString() {
        return "{" +
                "\"code\":" + code +
                ", \"message\":\"" + message + '\"' +
                ", \"data\":\"" + data + '\"' +
                ", \"success\":" + success +
                '}';
    }
}
