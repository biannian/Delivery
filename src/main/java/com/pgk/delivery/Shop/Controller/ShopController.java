package com.pgk.delivery.Shop.Controller;

import com.pgk.delivery.Model.Result;
import com.pgk.delivery.Service.LoginService;
import com.pgk.delivery.Shop.Pojo.Shop;
import com.pgk.delivery.Shop.Service.ShopService;
import com.pgk.delivery.Util.PassToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopService service;


    @RequestMapping("/queryAll.do")
    public Result<?> queryAll(int pageNum, int pageSize, HttpServletRequest request, HttpServletResponse response) {
        int accountLimit = (int) request.getAttribute("accountLimit");
        if (accountLimit == 1) {
            Result<?> shops = service.queryAll(pageNum, pageSize);
            return shops;
        } else {
            response.setStatus(403);
            return null;
        }
    }

    @RequestMapping("/queryByName.do")
    public Result<?> queryByName(String shopName, int pageNum, int pageSize, HttpServletRequest request, HttpServletResponse response) {
        int accountLimit = (int) request.getAttribute("accountLimit");
        if (accountLimit == 1) {
            Result<?> shop = service.queryByName(shopName, pageNum, pageSize);
            return shop;
        } else {
            response.setStatus(403);
            return null;
        }
    }

    @RequestMapping("/queryById.do")
    public Result<?> queryById(int shopId, HttpServletRequest request, HttpServletResponse response) {
        int accountLimit = (int) request.getAttribute("accountLimit");
        if (accountLimit == 1) {
            Result<?> shop = service.queryById(shopId);
            return shop;
        } else {
            response.setStatus(403);
            return null;
        }
    }

    @RequestMapping("/queryAllCommodity.do")
    public Result<?> queryAllCommodity(HttpServletRequest request, HttpServletResponse response) {
        int accountLimit = (int) request.getAttribute("accountLimit");
        if (accountLimit == 4) {
            Result<?> commoditys = service.queryAllCommodity();
            return commoditys;
        } else {
            response.setStatus(403);
            return null;
        }
    }

    @RequestMapping("/delectCommodity.do")
    public Result<?> delectCommodity(int commodityId, HttpServletRequest request, HttpServletResponse response) {
        int accountLimit = (int) request.getAttribute("accountLimit");
        if (accountLimit == 4 || accountLimit == 2) {
            Result<?> commoditys = service.delectCommodity(commodityId);
            if (commoditys.getCode() == -1) {
                response.setStatus(500);
                return null;
            }
            return Result.success();
        } else {
            response.setStatus(403);
            return null;
        }
    }


}
