package com.frank.boot.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


/**
 * 其抽象级别应该是用于对Controller进行“切面”环绕的
 * @author GuoZhong Xu
 */
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
