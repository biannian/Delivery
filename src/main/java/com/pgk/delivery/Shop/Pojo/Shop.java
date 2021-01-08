package com.pgk.delivery.Shop.Pojo;

import lombok.Data;

@Data
public class Shop {
    private String shopName;
    private String shopImg;
    private int shopSellerId;
    private String shopAddress;
    private String shopStartPrice;
    private String shopSendPrice;
    private String shopSalesVolume;
    private String shopCommodity;

}
