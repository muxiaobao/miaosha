package com.miaoshaproject.service;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.service.model.OrderModel;

public interface OrderService {

    // 创建用户订单
    OrderModel createOrder(Integer userId, Integer itemId, Integer amount) throws BusinessException;

    // 创建订单号
    String generateOrderNo();

}
