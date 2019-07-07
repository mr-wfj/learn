package com.wfj.learn.gateway.exception;


import com.wfj.learn.common.exception.CustomException;
import com.wfj.learn.common.result.Result;
import com.wfj.learn.gateway.result.ResultCode;
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
     * @return Result
     */
    @ExceptionHandler(CustomException.class)
    public Result handleCustomException(CustomException e) {
        logger.error(e.getResult().getMessage());
        return e.getResult();
    }

    /**
     * 处理参数校验异常
     *
     * @param e MethodArgumentNotValidException
     * @return Result
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        logger.error(e.getBindingResult().getFieldError().getField() + e.getBindingResult().getFieldError().getDefaultMessage());
        return Result.failure(ResultCode.BAD_REQUEST, e.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception e) {
        logger.error("error:", e);
        return Result.failure(ResultCode.SERVER_ERROR, e.getMessage());
    }


}
