package com.pgk.delivery.Order.Controller;


import com.pgk.delivery.Model.Result;
import com.pgk.delivery.Order.Pojo.Order;
import com.pgk.delivery.Order.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Order")
public class OrderController {
    @Autowired
    private OrderService service;

    @RequestMapping("/addOrder")
    public Result<?> addOrder(Order order){
        Result<?> msg = service.addOrder(order);
        return msg;
    }
}
