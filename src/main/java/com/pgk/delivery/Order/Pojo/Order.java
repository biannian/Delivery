package com.pgk.delivery.Order.Pojo;

import com.pgk.delivery.Shop.Pojo.Shop;
import lombok.Data;

import java.util.List;

@Data
public class Order {
    /**
     * 订单编号
     */
    private int orderId;
    /**
     * 店铺编号
     */
    private int shopId;
    /**
     * 买家用户名
     */
    private String orderBuyerId;
    /**
     * 卖家用户名
     */
    private String orderSellerId;
    /**
     * 骑手用户名
     */
    private String orderRiderId;
    /**
     * 订单状态码
     */
    private int orderState;
    /**
     * 下单时间
     */
    private String orderBuyerTime;
    /**
     * 收货时间
     */
    private String orderSellerTime;
    /**
     * 送达时间
     */
    private String orderRiderTime;
    /**
     * 存放商品的集合
     */
    private List<Shopping> shopping;
}
