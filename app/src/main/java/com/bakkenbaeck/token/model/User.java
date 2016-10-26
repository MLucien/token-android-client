package com.bakkenbaeck.token.model;


import java.math.BigInteger;

public class User {
    private String id;
    private BigInteger balance;
    private BigInteger confirmed_balance;
    private String auth_token;
    private String password_salt;
    private int level;
    private double eth_value;

    public String getId() {
        return id;
    }

    public User setId(final String id) {
        this.id = id;
        return this;
    }

    public BigInteger getUnconfirmedBalance() {
        return this.balance;
    }

    public BigInteger getConfirmedBalance() {
        return this.confirmed_balance;
    }

    public String getAuthToken() {
        return this.auth_token;
    }

    public String getPasswordSalt() {
        return this.password_salt;
    }

    public void setAuthToken(final String auth_token) {
        this.auth_token = auth_token;
    }

    public void setPasswordSalt(final String passwordSalt) {
        this.password_salt = passwordSalt;
    }

    public int getLevel() {
        return this.level;
    }

    public double getEthValue(){
        return eth_value;
    }
}
