package com.miaoshaproject.controller.viewobject;

import java.math.BigDecimal;

/**
 * 前端UI展示
 * ItemModel所有属性均可向前端暴露，因此ItemVO所有字段与ItemModel的一致，二者设计方式是对称的
 *
 * 实际场景中，VO可能会非常复杂：例如前端商品信息展示，不仅包括基本信息，还会加入许多促销活动等信息，
 * 因此VO和Model必须分层，并在必要的时候实现models聚合vo的操作
 */
public class ItemVO {
    private Integer id;
    private String title;
    private BigDecimal price;
    private Integer stock;
    private String description;
    private Integer sales;
    private String imgUrl;
}
