package com.pgk.delivery.Order.Mapper;


import com.pgk.delivery.Order.Pojo.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
   int addOrder(Order order);
}
