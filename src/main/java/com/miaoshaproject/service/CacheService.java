package com.miaoshaproject.service;

/**
 * 封装本地热点缓存操作类
 */
public interface CacheService {

    // 存方法
    void setCommonCache(String key, Object value);


    // 取方法
    Object getCommonCache(String key);
}
