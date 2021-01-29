package com.pgk.delivery.Order.Mapper;


import com.pgk.delivery.Order.Pojo.Order;
import com.pgk.delivery.Order.Pojo.Shopping;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
   int addOrder(Order order);

   int addShopping(Shopping shopping);

   int deleteCommodityNumber(Shopping shopping);

   List<Order> selectOrder(String orderBuyerId);

   List<Shopping> selectShopping(int shoppingOrderId);
}
