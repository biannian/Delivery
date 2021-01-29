package com.pgk.delivery.Order.Pojo;

import com.pgk.delivery.Shop.Pojo.Shop;
import lombok.Data;

import java.util.List;

@Data
public class Order {
    private int orderId;
    private int shopId;
    private String orderBuyerId;
    private String orderSellerId;
    private String orderRiderId;
    private int orderState;
    private String orderBuyerTime;
    private String orderSellerTime;
    private String orderRiderTime;


    private List<Shopping> shoppings;
}
