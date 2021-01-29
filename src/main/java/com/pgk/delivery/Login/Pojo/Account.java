package com.pgk.delivery.Login.Pojo;

import lombok.Data;

@Data
public class Account {
    private String accountName;
    private String accountPassword;
    private int accountLimit;
    private int accountBan;
    private int accountId;
    private int accountUserId;
    private String table;
    private String tableId;
    private String tableAccountName;
}
