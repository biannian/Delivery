package com.pgk.delivery.Login.Controller;

import com.pgk.delivery.Login.Pojo.Account;
import com.pgk.delivery.Login.Service.LoginService;
import com.pgk.delivery.Util.PassToken;
import com.pgk.delivery.Model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/Login")
public class LoginController {

    @Autowired
    private LoginService service;

    @PassToken
    @RequestMapping(value = "/login.do")
    public Result<?> login(String accountName, String accountPassword) {
        Result<?> result = service.login(accountName, accountPassword);

        return result;
    }

    @PassToken
    @RequestMapping(value = "/queryById.do")
    public boolean queryById(String accountName) {
        Result<?> account = service.queryById(accountName);
        if (account.getCode() == 200){
            return true;
        }else {
            return false;
        }

    }

    @PassToken
    @RequestMapping(value = "/queryAll.do")
    public Result<?> queryAll(HttpServletRequest req) {
        Result<?> result = service.queryAll();
        return result;
    }

    @RequestMapping(value = "/getLimit.do")
    public Result<?> getLimit(HttpServletRequest req) {
        int accountLimit = (int) req.getAttribute("accountLimit");
        int accountUserId = (int) req.getAttribute("accountUserId");
        String accountName = (String) req.getAttribute("accountName");
        Map map = new HashMap();
        map.put("accountUserId",accountUserId);
        map.put("accountLimit", accountLimit);
        map.put("accountName", accountName);
        return Result.success(map);
    }

    @RequestMapping(value = "/accountDelete.do")
    public Result<?> accountDelete(HttpServletRequest req, int accountId, HttpServletResponse response) {
        int accountLimit = (int) req.getAttribute("accountLimit");
        if (accountLimit == 4) {
            Result<?> result = service.accountDelete(accountId);
            if (result.getCode() == -1) {
                response.setStatus(500);
                return null;
            }
            return Result.success();
        }
        return Result.fail(-1);
    }

    @RequestMapping(value = "/accountEdit.do")
    public Result<?> accountEdit(HttpServletRequest req, Account account, HttpServletResponse response) {
        int accountLimit = (int) req.getAttribute("accountLimit");
        if (accountLimit == 4) {
            Result<?> result = service.accountEdit(account);
            if (result.getCode() == -1) {
                response.setStatus(500);
                return null;
            }
            return Result.success();
        }
        return Result.fail(-1);
    }

    @PassToken
    @RequestMapping(value = "/register.do")
    public Result<?> register(Account account) {
        Result<?> msg = service.register(account);
        return msg;
    }
}