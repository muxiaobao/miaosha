package com.miaoshaproject.service;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.service.model.OrderModel;

/**
 * 引入秒杀活动模型后，交易接口应作出相应的改变，有2种设计方式：
 * 1. 通过前端url传过来的秒杀活动id，然后在createOrder接口内校验对应promo_id是否属于对应商品且活动已开始 （orderModel,orderDO添加promo_id字段必要性）
 * 2. 直接在createOrder接口内判断对应的商品是否存在秒杀活动，若存在进行中的则以秒杀价格下单
 *
 * 以上2种方案各有优劣，从最大优势的角度说，第一种更好，这是因为：首先考略业务逻辑上的可扩展性，一个商品同一时间可能存在
 * 于多个秒杀活动之内，因此必须通过前端用户的访问路径（如app种类）判断用户是从哪一个秒杀入口进来下单；
 * 其次，若按照第二种方案，则还要再订单接口中还要判断秒杀活动的领域模型，相当于任何平销的商品也要查询其对应活动的信息，
 * 会损害下单链路的接口性能
 */

public interface OrderService {

    // 创建用户订单
    OrderModel createOrder(Integer userId, Integer itemId, Integer promoId, Integer amount, String stockLogId) throws BusinessException;

    // 创建订单号
    String generateOrderNo();

}
