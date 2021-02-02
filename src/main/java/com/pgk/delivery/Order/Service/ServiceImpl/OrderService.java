package com.pgk.delivery.Order.Service.ServiceImpl;

import com.pgk.delivery.Model.Result;
import com.pgk.delivery.Order.Mapper.OrderMapper;
import com.pgk.delivery.Order.Pojo.Order;
import com.pgk.delivery.Order.Pojo.Shopping;
import com.pgk.delivery.Shop.Mapper.ShopMapper;
import com.pgk.delivery.Shop.Pojo.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class OrderService implements com.pgk.delivery.Order.Service.OrderService {

    @Autowired
    private OrderMapper mapper;

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public Result<?> addOrder(Order order) {
        mapper.addOrder(order);
        for (int i = 0; i < order.getShopping().size(); i++) {
            //根据i来循环order实体里的商品，
            order.getShopping().get(i).setShoppingOrderId(order.getOrderId());

            mapper.addShopping(order.getShopping().get(i));
            //A为订单中商品数量，commodityNumber为商品库存
            order.getShopping().get(i).setCommodityNumber(
                    order.getShopping().get(i).getCommodityNumber()
                            - order.getShopping().get(i).getA());

            mapper.deleteCommodityNumber(order.getShopping().get(i));
        }
        return Result.success();
    }

    @Override
    public Result<?> selectOrder(String orderBuyerId) {
        List<Order> orders = mapper.selectOrder(orderBuyerId);

        List<List<Shopping>> shoppings = new ArrayList<>();
        HashMap<Integer,String> shops  = new HashMap<>();

        for (int i = 0; i < orders.size(); i++) {
            //根据订单中的店铺编号查询店铺信息
            shops.put(orders.get(i).getShopId(),shopMapper.queryForName(orders.get(i).getShopId()));
            //根据订单编号去查询中间表中的商品
            shoppings.add(mapper.selectShopping(orders.get(i).getOrderId()));
        }
        HashMap<String, Object> orderMap = new HashMap<>();
        orderMap.put("shoppings", shoppings);
        orderMap.put("orders", orders);
        orderMap.put("shops", shops);
        return Result.success(orderMap);
    }
}
