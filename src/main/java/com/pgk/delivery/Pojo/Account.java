package com.pgk.delivery.Pojo;

public class Account {
    private String accountName;
    private String accountPassword;
    private int accountLimit;
        private int accountBan;

    @Override
    public String toString() {
        return "Account{" +
                "accountName='" + accountName + '\'' +
                ", accountPassword='" + accountPassword + '\'' +
                ", accountLimit=" + accountLimit +
                ", accountBan=" + accountBan +
                '}';
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public int getAccountLimit() {
        return accountLimit;
    }

    public void setAccountLimit(int accountLimit) {
        this.accountLimit = accountLimit;
    }

    public int getAccountBan() {
        return accountBan;
    }

    public void setAccountBan(int accountBan) {
        this.accountBan = accountBan;
    }

    public Account(String accountName, String accountPassword, int accountLimit, int accountBan) {
        this.accountName = accountName;
        this.accountPassword = accountPassword;
        this.accountLimit = accountLimit;
        this.accountBan = accountBan;
    }

    public Account() {
    }
}
