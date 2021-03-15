package com.miaoshaproject.service.Impl;

import com.miaoshaproject.dao.PromoDOMapper;
import com.miaoshaproject.dataobject.PromoDO;
import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.error.EmBusinessError;
import com.miaoshaproject.service.ItemService;
import com.miaoshaproject.service.PromoService;
import com.miaoshaproject.service.UserService;
import com.miaoshaproject.service.model.ItemModel;
import com.miaoshaproject.service.model.PromoModel;
import com.miaoshaproject.service.model.UserModel;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class PromoServiceImpl implements PromoService {

    @Autowired
    private PromoDOMapper promoDOMapper;

    @Autowired
    private ItemService itemService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserService userService;



    @Override
    public PromoModel getPromoByItemId(Integer itemId) {
        // 获取对应商品的秒杀活动信息
        PromoDO promoDO = promoDOMapper.selectByItemId(itemId);

        // data object转化为model
        PromoModel promoModel = this.convertModelFromDO(promoDO);
        if (promoModel == null) {
            return null;
        }

        // 判断当前时间秒杀活动是否即将开始或正在进行
        if (promoModel.getStartDate().isAfterNow()) {
            promoModel.setStatus(1);
        } else if (promoModel.getEndDate().isAfterNow()) {
            promoModel.setStatus(2);
        } else {
            promoModel.setStatus(3);
        }

        return promoModel;
    }

    @Override
    public void publishPromo(Integer promoId) {
        // 通过活动id获取活动
        PromoDO promoDO = promoDOMapper.selectByPrimaryKey(promoId);
        if (promoDO == null || promoDO.getItemId().intValue() == 0) {
            return;
        }
        // 获取item model
        ItemModel itemModel = itemService.getItemById(promoDO.getItemId());

        // 将item stock存入缓存
        redisTemplate.opsForValue().set("promo_item_stock_"+itemModel.getId(), itemModel.getStock());
    }

    @Override
    public String generateSecondKillToken(Integer promoId, Integer itemId, Integer userId) {
        // 1. 校验活动信息
        PromoDO promoDO = promoDOMapper.selectByPrimaryKey(promoId);
        PromoModel promoModel = convertModelFromDO(promoDO);
        if (promoModel == null) {
            return null;
        }
        // 判断当前时间秒杀活动是否即将开始或正在进行
        if (promoModel.getStartDate().isAfterNow()) {
            promoModel.setStatus(1);
        } else if (promoModel.getEndDate().isAfterNow()) {
            promoModel.setStatus(2);
        } else {
            promoModel.setStatus(3);
        }
        // 仅当活动正在进行中（即status=2）才会生成秒杀令牌
        if (promoModel.getStatus().intValue() != 2) {
            return null;
        }

        // 2. 校验商品信息
        ItemModel itemModel = itemService.getItemByIdInCache(itemId);
        if (itemModel == null) {
            return null;
        }

        // 3. 校验用户信息
        UserModel userModel = userService.getUserByIdInCache(userId);
        if (userModel == null) {
            return null;
        }

        // 4. 生成秒杀令牌，存入redis缓存
        String token = UUID.randomUUID().toString().replace("-","");

        redisTemplate.opsForValue().set("promo_token_"+promoId+"_user_id_"+userId+"_item_id_"+itemId, token);
        redisTemplate.expire("promo_token_"+promoId, 5, TimeUnit.MINUTES);

        return token;
    }

    private PromoModel convertModelFromDO(PromoDO promoDO) {
        if (promoDO == null) {
            return null;
        }
        PromoModel promoModel = new PromoModel();
        BeanUtils.copyProperties(promoDO, promoModel);
        promoModel.setPromoItemPrice(new BigDecimal(promoDO.getPromoItemPrice().doubleValue()));
        promoModel.setStartDate(new DateTime(promoDO.getStartDate()));
        promoModel.setEndDate(new DateTime(promoDO.getEndDate()));

        return promoModel;
    }
}
