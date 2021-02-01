package com.pgk.delivery.Order.Service;

import com.pgk.delivery.Model.Result;
import com.pgk.delivery.Order.Pojo.Order;

public interface OrderService {
    Result<?> addOrder(Order order);

    Result<?> selectOrder(String orderBuyerId);
}
