package com.miaoshaproject.service;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.service.model.ItemModel;

import java.util.List;

public interface ItemService {

    // 创建商品
    ItemModel createItem(ItemModel itemModel) throws BusinessException;

    // 商品列表浏览
    List<ItemModel> listItem();

    // 商品详情浏览
    ItemModel getItemById(Integer id);

    // 库存扣减 (针对redis缓存)
    boolean decreaseStock(Integer id, Integer amount);

    // 库存回补 (针对redis缓存)
    boolean increaseStock(Integer id, Integer amount);

    // 异步更新库存 (MQ send)
    boolean asyncDecreaseStock(Integer id, Integer amount);

    // 销量增加
    void increaseSales(Integer itemId, Integer amount);

    // item 及 promo model缓存模型
    ItemModel getItemByIdInCache(Integer id);

}
