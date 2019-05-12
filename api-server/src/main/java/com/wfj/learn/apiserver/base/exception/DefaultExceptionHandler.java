package com.wfj.learn.apiserver.base.exception;


import com.wfj.learn.apiserver.base.result.ResultCode;
import com.wfj.learn.apiserver.base.result.ResultJson;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author WFJ
 * 异常处理类
 * controller 层异常无法捕获处理，需要自己处理
 */
@RestControllerAdvice
@Slf4j
public class DefaultExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(DefaultExceptionHandler.class);


    /**
     * 处理所有自定义异常
     *
     * @param e CustomException
     * @return ResultJson
     */
    @ExceptionHandler(CustomException.class)
    public ResultJson handleCustomException(CustomException e) {
        logger.error(e.getResultJson().getMsg());
        return e.getResultJson();
    }

    /**
     * 处理参数校验异常
     *
     * @param e MethodArgumentNotValidException
     * @return ResultJson
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultJson handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        logger.error(e.getBindingResult().getFieldError().getField() + e.getBindingResult().getFieldError().getDefaultMessage());
        return ResultJson.failure(ResultCode.BAD_REQUEST, e.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResultJson exceptionHandler(Exception e) {
        logger.error("error:", e);
        return ResultJson.failure(ResultCode.SERVER_ERROR, e.getMessage());
    }


}
