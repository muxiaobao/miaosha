package com.miaoshaproject.service;


import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.service.model.UserModel;

public interface UserService {

    // 通过用户ID获取用户对象
    UserModel getUserById(Integer id);

    // 用户注册
    void register(UserModel userModel) throws BusinessException;

    //用户登录校验
    /**
     *
     * @param telephone: 用户注册手机
     * @param encryptPassword: 加密后的用户密码
     */
    UserModel validateLogin(String telephone, String encryptPassword) throws BusinessException;

    // user model 缓存模型
    UserModel getUserByIdInCache(Integer id);

}
