package com.miaoshaproject.controller;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.error.EmBusinessError;
import com.miaoshaproject.response.CommonReturnType;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 建立全局异常处理器，因为handlerException在BaseController中无法截获404错误
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonReturnType doError(HttpServletRequest req, HttpServletResponse resp, Exception exception) {
        exception.printStackTrace();
        Map<String, Object> responseData = new HashMap<>();
        if (exception instanceof BusinessException) {
            BusinessException ex = (BusinessException) exception;
            responseData.put("errCode", ex.getErrCode());
            responseData.put("errMsg", ex.getErrMsg());
        } else if (exception instanceof ServletRequestBindingException) {
            responseData.put("errCode", EmBusinessError.UNKNOWN_ERROR.getErrCode());
            responseData.put("errMsg", "url绑定路由问题");
        } else if (exception instanceof NoHandlerFoundException) {
            responseData.put("errCode", EmBusinessError.UNKNOWN_ERROR.getErrCode());
            responseData.put("errMsg", "没有找到对应的访问路径");
        } else {
            responseData.put("errCode", EmBusinessError.UNKNOWN_ERROR.getErrCode());
            responseData.put("errMsg", EmBusinessError.UNKNOWN_ERROR.getErrMsg());
        }

        return CommonReturnType.create(responseData, "fail");
    }
}
