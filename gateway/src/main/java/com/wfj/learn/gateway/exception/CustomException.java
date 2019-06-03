package com.wfj.learn.gateway.exception;

import com.wfj.learn.gateway.result.Result;
import lombok.Getter;

/**
 * @author WFJ
 */
@Getter
public class CustomException extends RuntimeException {

    private Result result;

    public CustomException(Result result) {
        this.result = result;
    }
}
