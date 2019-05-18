package com.wfj.learn.apiserver.base.exception;

import com.wfj.learn.apiserver.base.result.Result;
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
