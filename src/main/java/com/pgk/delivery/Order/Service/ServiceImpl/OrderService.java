package com.pgk.delivery.Order.Service.ServiceImpl;

import com.pgk.delivery.Model.Result;
import com.pgk.delivery.Order.Mapper.OrderMapper;
import com.pgk.delivery.Order.Pojo.Order;
import com.pgk.delivery.Order.Pojo.Shopping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


@Service
public class OrderService implements com.pgk.delivery.Order.Service.OrderService {

    @Autowired
    private OrderMapper mapper;

    @Override
    public Result<?> addOrder(Order order) {
        mapper.addOrder(order);
        for (int i = 0; i <order.getShoppings().size() ; i++) {
           order.getShoppings().get(i).setShoppingOrderId(order.getOrderId());
            mapper.addShopping(order.getShoppings().get(i));
            order.getShoppings().get(i).setShoppingNumber(
                    order.getShoppings().get(i).getShoppingNumber()
                            -order.getShoppings().get(i).getA());
            mapper.deleteCommodityNumber(order.getShoppings().get(i));
        }
        return Result.success();
    }

    @Override
    public Result<?> selectOrder(String orderBuyerId) {
       List<Order> orders = mapper.selectOrder(orderBuyerId);

        List<List<Shopping>> shoppings = new ArrayList<>();

        for (int i = 0; i <orders.size() ; i++) {
           shoppings.add(mapper.selectShopping(orders.get(i).getOrderId()));
        }
        HashMap<String, Object> orderMap = new HashMap<>();
            orderMap.put("shoppings",shoppings);
            orderMap.put("orders",orders);
//        HashMap<Integer, List<Order>> orderMap = new HashMap<>();
//        for (int i = 0; i <orders.size() ; i++) {
//            List<Order> list = orderMap.get(orders.get(i).getOrderId());
//            if (list == null)
//                list = new ArrayList<>();
//            list.add(orders.get(i));
//            orderMap.put(orders.get(i).getOrderId(),list) ;
//        }
        return Result.success(orderMap);
    }
}
