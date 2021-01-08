package com.pgk.delivery.Shop.Service.ServiceImpl;

import com.pgk.delivery.Model.Result;
import com.pgk.delivery.Shop.Mapper.ShopMapper;
import com.pgk.delivery.Shop.Pojo.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService implements com.pgk.delivery.Shop.Service.ShopService {

    @Autowired
    private ShopMapper mapper;

    @Override
    public Result<?> queryAll() {
        List<Shop> shop = mapper.queryAll();
        return Result.success(shop);
    }
}
