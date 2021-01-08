package com.pgk.delivery.Shop.Controller;

import com.pgk.delivery.Model.Result;
import com.pgk.delivery.Service.LoginService;
import com.pgk.delivery.Shop.Pojo.Shop;
import com.pgk.delivery.Shop.Service.ShopService;
import com.pgk.delivery.Util.PassToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopService service;


    @RequestMapping("/queryAll.do")
    public Result<?> queryAll(){
        System.out.println("测试");
        Result<?> shops = service.queryAll();
        return shops;
    }
}
