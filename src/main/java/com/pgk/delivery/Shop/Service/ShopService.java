package com.pgk.delivery.Shop.Service;

import com.pgk.delivery.Model.Result;
import com.pgk.delivery.Shop.Pojo.Commodity;

public interface ShopService {
    Result<?> queryAll(int pageNum, int pageSize);

    Result<?> queryById(int shopId);

    Result<?> queryByName(String shopName, int pageNum, int pageSize);

    Result<?> queryAllCommodity(String commodityShopId);

    Result<?> delectCommodity(int commodityId);

    Result<?> selectMenu();

    Result<?> commodityAdd(Commodity commodity);

    Result<?> queryShopName(int sellerId);

    Result<?> addMenu(String shopMenuName);

    Result<?> commodityEdit(Commodity commodity);
}
