package com.pgk.delivery.Shop.Mapper;

import com.pgk.delivery.Shop.Pojo.Shop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopMapper {
     List<Shop> queryAll();
}
