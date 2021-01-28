package com.pgk.delivery.Order.Pojo;

import lombok.Data;

@Data
public class Order {
    private int orderId;
    private int orderBuyerId;
    private int orderSellerId;
    private int orderRiderId;
    private int orderState;
    private String orderBuyerTime;
    private String orderSellerTime;
    private String orderRiderTime;
}
