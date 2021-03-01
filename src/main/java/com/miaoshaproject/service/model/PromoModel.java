package com.miaoshaproject.service.model;

import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * 秒杀模型, 为简单起见，同一个秒杀活动仅使用一种商品
 */
public class PromoModel {


    private Integer id;

    // 秒杀活动状态 1表示还未开始， 2表示正在进行   3表示已结束 【外部service直接查看该字段，不必自己比较判断】
    private Integer status;

    // 秒杀活动名
    private String promoName;

    // 秒杀活动开始时间
    private DateTime startDate;

    // 秒杀活动的结束时间
    private DateTime endDate;

    // 秒杀活动适用商品
    private Integer itemId;
    
    // 秒杀活动商品价格
    private BigDecimal promoItemPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPromoName() {
        return promoName;
    }

    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getPromoItemPrice() {
        return promoItemPrice;
    }

    public void setPromoItemPrice(BigDecimal promoItemPrice) {
        this.promoItemPrice = promoItemPrice;
    }

    public DateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(DateTime endDate) {
        this.endDate = endDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
