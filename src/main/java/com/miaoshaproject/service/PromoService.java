package com.miaoshaproject.service;

import com.miaoshaproject.service.model.PromoModel;

/**
 * 秒杀服务的业务逻辑：
 *    1. 商品详情页展示的是当前商品的平销价格
 *    2. 秒杀服务要根据当前商品的id查询出该商品即将发生或正在进行的秒杀活动，并展示出对应的秒杀价格
 */
public interface PromoService {

    PromoModel getPromoByItemId(Integer itemId);
}
