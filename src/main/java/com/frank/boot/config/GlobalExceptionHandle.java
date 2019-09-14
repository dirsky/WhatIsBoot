package com.frank.boot.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandle {
    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public Map<String, Object> exceptionHandle() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 500);
        map.put("msg", "error");
        return map;
    }
}
