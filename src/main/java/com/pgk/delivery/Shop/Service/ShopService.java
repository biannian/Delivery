package com.pgk.delivery.Shop.Service;

import com.pgk.delivery.Model.Result;
import com.pgk.delivery.Shop.Pojo.Commodity;
import com.pgk.delivery.Shop.Pojo.Shop;

public interface ShopService {
    Result<?> queryAll(int pageNum, int pageSize);

    Result<?> queryById(int shopId);

    Result<?> queryByName(String shopName, int pageNum, int pageSize);

    Result<?> queryAllCommodity(Integer accountUserId);

    Result<?> delectCommodity(int commodityId);

    Result<?> selectMenu();

    Result<?> commodityAdd(Commodity commodity);

    Result<?> queryShopName(int sellerId);

    Result<?> addMenu(String shopMenuName);

    Result<?> commodityEdit(Commodity commodity);

    Result<?> selectShopInformation(int sellerId);

    Result<?> updateShopInformation(Shop shop);
}
