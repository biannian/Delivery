package com.pgk.delivery.Order.Pojo;

import lombok.Data;

@Data
public class Shopping {
    private int shoppingCommodityId;
    private int a;
    private int shoppingOrderId;

    private int shoppingNumber;

    private String commodityName;
    private String commodityImg;
    private double commodityPrice;
}
