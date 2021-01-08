package com.pgk.delivery.Controller;

import com.pgk.delivery.Pojo.Account;
import com.pgk.delivery.Service.LoginService;
import com.pgk.delivery.Util.JWTUtil;
import com.pgk.delivery.Util.PassToken;
import com.pgk.delivery.Model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/Login")
public class LoginController {

    @Autowired
    private LoginService service;

    @PassToken
    @RequestMapping(value = "/login.do")
    public Result<?> login(String accountName, String accountPassword){
        System.out.println(accountName);
        Result<?> result =service.login(accountName,accountPassword );
            return result;
    }
    @PassToken
    @RequestMapping(value = "/queryById.do")
    public  Result<?> queryById(String accountName){
        Result<?> account = service.queryById(accountName);
        return account;
    }
    @RequestMapping(value = "/queryAll.do")
    public Result<?> queryAll(HttpServletRequest req){
        System.out.println(req.getHeader("token"));
        Result<?> account = service.queryAll();

        System.out.println(account.getResult());
        return account;
    }

    @RequestMapping(value = "/checkToken.do")
    public Result<?> checkToken(HttpServletRequest req) {
        return Result.success(200);
    }

    @PassToken
    @RequestMapping(value = "/register.do")
    public Result<?> register(Account account){
        Result<?> msg = service.register(account);
        return msg;
    }

}
