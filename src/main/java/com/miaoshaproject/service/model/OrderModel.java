package com.miaoshaproject.service.model;

import java.math.BigDecimal;

// 用户下单的交易模型
public class OrderModel {

    //企业级应用的订单号是有明确属性的，如2021022810001xxx，因此使用string类型
    private String id;

    //购买的用户id
    private Integer userId;

    //购买的商品id
    private Integer itemId;

    //购买数量
    private Integer amount;

    // 若非空，表示是以秒杀商品方式下单
    private Integer promoId;

    //购买的商品单价， 若promoId非空，表示是秒杀商品价格
    private BigDecimal itemPrice;

    //订单金额， 若promoId非空，表示是秒杀订单总价
    private BigDecimal orderPrice;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getPromoId() {
        return promoId;
    }

    public void setPromoId(Integer promoId) {
        this.promoId = promoId;
    }
}
