package com.pgk.delivery.Login.Mapper;

import com.pgk.delivery.Login.Pojo.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoginMapper {


    public Account login(String accountName, String accountPassword);

    public List<Account> queryById(String accountName);

    public Account queryByName(String accountName);

    public List<Account> queryAll();

    public int register(Account account);

    int accountDelete(int accountId);

    int accountEdit(Account account);
}
