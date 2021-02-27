package com.miaoshaproject.validator;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 保存验证后的信息
 */
public class ValidationResult {

    // 校验结果
    private boolean hasErrors = false;

    // 存放错误信息的map，key:错误字段名   value:错误信息
    private Map<String,String> errorMsgMap = new HashMap<>();


    public boolean isHasErrors() {
        return hasErrors;
    }

    public void setHasErrors(boolean hasErrors) {
        this.hasErrors = hasErrors;
    }

    public Map<String, String> getErrMsgMap() {
        return errorMsgMap;
    }

    public void setErrMsgMap(Map<String, String> errorMsgMap) {
        this.errorMsgMap = errorMsgMap;
    }


    // 实现通用的通过格式化字符串信息获取错误结果的msg方法 【可能有多条错误信息】
    public String getErrorMsg(){
        return StringUtils.join(errorMsgMap.values().toArray(), ",");
    }
}
