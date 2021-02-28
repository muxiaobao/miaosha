package com.miaoshaproject.controller.viewobject;

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
