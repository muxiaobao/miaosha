package com.miaoshaproject.controller.viewobject;

import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * 前端UI展示
 * ItemModel所有属性均可向前端暴露，因此ItemVO所有字段与ItemModel的一致，二者设计方式是对称的
 *
 * 实际场景中，VO可能会非常复杂：例如前端商品信息展示，不仅包括基本信息，还会加入许多促销活动等信息，
 * 因此VO和Model必须分层，并在必要的时候实现models聚合vo的操作
 *
 * NOTE: VO对象应添加getter， setter方法，否则在使用Jackson序列化该对象时会抛出异常：
 * HttpMessageConversionException：nested exception is com.fasterxml.jackson.databind.exc.InvalidDefinitionException:
 * No serializer found for class ItemVO and no properties discovered to create BeanSerializer
 */
public class ItemVO {
    private Integer id;
    private String title;
    private BigDecimal price;
    private Integer stock;
    private String description;
    private Integer sales;
    private String imgUrl;

    // 记录商品是否在秒杀活动中，以及对应的状态： 0-没有活动   1-活动待开始   2-活动正在进行
    private Integer promoStatus;

    // 秒杀活动价格
    private BigDecimal promoPrice;

    // 秒杀活动id
    private Integer promoId;

    // 秒杀活动开始时间 （作倒计时展示）
    private DateTime startDate;


    public Integer getPromoStatus() {
        return promoStatus;
    }

    public void setPromoStatus(Integer promoStatus) {
        this.promoStatus = promoStatus;
    }

    public BigDecimal getPromoPrice() {
        return promoPrice;
    }

    public void setPromoPrice(BigDecimal promoPrice) {
        this.promoPrice = promoPrice;
    }

    public Integer getPromoId() {
        return promoId;
    }

    public void setPromoId(Integer promoId) {
        this.promoId = promoId;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
