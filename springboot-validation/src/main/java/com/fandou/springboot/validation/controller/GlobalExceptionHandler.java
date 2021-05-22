package com.fandou.springboot.validation.controller;

import com.fandou.springboot.validation.support.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * 全局异常处理器类
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理ConstraintViolationException异常
     *
     * @param ex ConstraintViolationException异常
     * @return Result
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Result resolveConstraintViolationException(ConstraintViolationException ex) {
        LOGGER.error("ConstraintViolationException happened:");
        Result errorResult = new Result();
        errorResult.setCode("101");
        String message = ex.getMessage();
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        if(!CollectionUtils.isEmpty(constraintViolations)){
            StringBuilder msgBuilder = new StringBuilder();
            for(ConstraintViolation constraintViolation : constraintViolations){
                msgBuilder.append(constraintViolation.getMessage()).append(",");
            }
            int length = msgBuilder.length();
            if(length > 1){
                msgBuilder.deleteCharAt(length - 1);
            }
            message = msgBuilder.toString();
        }
        errorResult.setMessage(message);
        LOGGER.error("ConstraintViolationException details: {}", message);
        return errorResult;
    }

    /**
     * 处理MethodArgumentNotValidException异常
     *
     * @param ex MethodArgumentNotValidException异常
     * @return Result
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result resolveMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        LOGGER.error("MethodArgumentNotValidException happened:");
        Result errorResult = new Result();
        errorResult.setCode("102");
        String message = ex.getMessage();
        List<ObjectError> objectErrors = ex.getBindingResult().getAllErrors();
        if(!CollectionUtils.isEmpty(objectErrors)) {
            StringBuilder msgBuilder = new StringBuilder();
            for (ObjectError objectError : objectErrors) {
                msgBuilder.append(objectError.getDefaultMessage()).append(",");
            }
            int length = msgBuilder.length();
            if(length > 1){
                msgBuilder.deleteCharAt(length - 1);
            }
            message = msgBuilder.toString();
        }
        errorResult.setMessage(message);
        LOGGER.error("MethodArgumentNotValidException details: {}", message);
        return errorResult;
    }

    /**
     * 处理Throwable错误
     *
     * @param th Throwable
     * @return Result
     */
    @ExceptionHandler(Throwable.class)
    public Result resolveThrowable(Throwable th) {
        LOGGER.error("Throwable happened:");
        Result errorResult = new Result();
        errorResult.setCode("103");
        String message = th.getMessage();
        errorResult.setMessage(message);
//        errorResult.setMessage("system exception.");
        LOGGER.error("Throwable message:{}", message);
        Throwable cause = th.getCause();
        if (!Objects.isNull(cause)) {
            String causeMessage = cause.getMessage();
            LOGGER.error("Throwable cause Message:{}", causeMessage);
            if (!Objects.isNull(causeMessage)) {
                errorResult.setMessage(causeMessage);
            }
        }
        return errorResult;
    }
}
