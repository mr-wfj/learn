package com.wfj.learn.apiserver.base.result;

import lombok.Data;

/**
 * @author WFJ
 * RESTful API 返回类型
 */
@Data
public class Result<T> {

    private static final long serialVersionUID = 783015033603078674L;
    private int code;
    private String msg;
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

    public Result(ResultCode resultCode, T data) {
        setResultCode(resultCode);
        this.data = data;
    }

    public void setResultCode(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    @Override
    public String toString() {
        return "{" +
                "\"code\":" + code +
                ", \"msg\":\"" + msg + '\"' +
                ", \"data\":\"" + data + '\"' +
                '}';
    }
}
