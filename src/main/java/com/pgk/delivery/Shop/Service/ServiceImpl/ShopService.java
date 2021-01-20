package com.pgk.delivery.Shop.Service.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pgk.delivery.Model.Result;
import com.pgk.delivery.Shop.Mapper.ShopMapper;
import com.pgk.delivery.Shop.Pojo.Commodity;
import com.pgk.delivery.Shop.Pojo.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class ShopService implements com.pgk.delivery.Shop.Service.ShopService {

    @Autowired
    private ShopMapper mapper;

    @Override
    public Result<?> queryAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Shop> shop = mapper.queryAll();
        PageInfo<Shop> page = new PageInfo<>(shop);
        return Result.success(page);
    }

    @Override
    public Result<?> queryById(int shopId) {
        if (shopId <= 0) {
            return Result.fail(-1, "没有此店铺");
        }
        Shop shop = mapper.queryById(shopId);
        if (shop == null) {
            return Result.fail(-1, "没有此店铺");
        }
        List<Commodity> commoditys = shop.getCommodity();
        Map shopMenu = new HashMap<>();
        for (Commodity com :
                commoditys) {
            shopMenu.put(com.getCommodityMenuId(), com.getShopMenuName());
        }
        shop.getCommodity().sort(Comparator.comparing(commodity -> commodity.getShopMenuId()));
        Map map = new HashMap();
        map.put("shopMenu", shopMenu);
        map.put("shop", shop);
        return Result.success(map);
    }

    @Override
    public Result<?> queryByName(String shopName, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Shop> shop = mapper.queryByName(shopName);

        if (!String.valueOf(shop).equals("")) {
            PageInfo<Shop> page = new PageInfo<>(shop);
            return Result.success(page);
        } else {
            return Result.fail(-1, "没有此店铺");
        }

    }

    @Override
    public Result<?> queryAllCommodity() {
        List<Commodity> commodities = mapper.queryAllCommodity();
        return Result.success(commodities);
    }

    @Override
    public Result<?> delectCommodity(int commodityId) {
        if (commodityId > 0) {
            int a = mapper.delectCommodity(commodityId);
            if (a == 1) {
                return Result.success();
            }
        }
        return Result.fail(-1);
    }
}
