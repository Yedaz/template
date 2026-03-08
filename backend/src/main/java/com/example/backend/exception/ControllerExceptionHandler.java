package com.example.backend.exception;

import cn.dev33.satoken.exception.NotLoginException;
import com.example.backend.response.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(Exception.class)
    public R handleException(Exception e){
        return R.fail(e.getMessage());
    }
    @ExceptionHandler(BussinessException.class)
    public R handleBussinessException(BussinessException e){
        return R.fail(e.getCode(),e.getMessage());
    }
    @ExceptionHandler(NotLoginException.class)
    public R handleBussinessException(NotLoginException e){
        return R.fail(e.getCode(),e.getMessage());
    }
}
