package com.pgk.delivery.Order.Service.ServiceImpl;

import com.pgk.delivery.Model.Result;
import com.pgk.delivery.Order.Mapper.OrderMapper;
import com.pgk.delivery.Order.Pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService implements com.pgk.delivery.Order.Service.OrderService {

    @Autowired
    private OrderMapper mapper;

    @Override
    public Result<?> addOrder(Order order) {
        int msg = mapper.addOrder(order);
        if (msg == 1){
            return Result.success(msg);
        }else {
            return Result.fail();
        }

    }
}
