package com.wfj.learn.apiserver.base.exception;

import com.wfj.learn.apiserver.base.result.ResultJson;
import lombok.Getter;

/**
 * @author WFJ
 */
@Getter
public class CustomException extends RuntimeException {

    private ResultJson resultJson;

    public CustomException(ResultJson resultJson) {
        this.resultJson = resultJson;
    }
}
