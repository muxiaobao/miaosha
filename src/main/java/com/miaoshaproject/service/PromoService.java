package com.miaoshaproject.service;

import com.miaoshaproject.service.model.PromoModel;

/**
 * 秒杀服务的业务逻辑：
 *    1. 商品详情页展示的是当前商品的平销价格
 *    2. 秒杀服务要根据当前商品的id查询出该商品即将发生或正在进行的秒杀活动，并展示出对应的秒杀价格
 *
 *
 * 活动发布机制：
 *    item model在从数据库内读取出来、拿到库存信息，直到存入缓存的过程中，该商品可能会被售卖；
 *    比如某商品在普通售卖状态下库存为10件，库存信息存入缓存过程中可能会以原价售卖一部分，无法确定
 *    参与秒杀活动的商品库存实际数量 ———— 因此实际业务开发中采取商品上下架方式，使得商品在活动未开始前不能售卖
 *    【本项目未实现此逻辑，且默认活动发布过程中不售卖商品】
 */
public interface PromoService {

    PromoModel getPromoByItemId(Integer itemId);

    // 活动发布, 实际应该由运维调取该方法来发布活动
    void publishPromo(Integer promoId);

    // 生成秒杀令牌 ———— promoToken：promoId+itemId+userId，即同一个用户只能参与一个秒杀活动，抢购一类商品
    String generateSecondKillToken(Integer promoId, Integer itemId, Integer userId);
}
