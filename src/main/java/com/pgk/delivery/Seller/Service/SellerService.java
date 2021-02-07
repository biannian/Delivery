package com.pgk.delivery.Seller.Service;

import com.pgk.delivery.Buyer.Pojo.Buyer;
import com.pgk.delivery.Model.Result;


public interface SellerService {
    Result<?> getSellerAddress(String accountName);

    Result<?> updateSellerAddress(Buyer buyer);
}
