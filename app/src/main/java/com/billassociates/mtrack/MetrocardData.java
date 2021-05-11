package com.billassociates.mtrack;

import java.util.Date;

public class MetrocardData {
    private String name;
    private int balance;
    private Date expiration;
    //datatype to hold image?

    public MetrocardData()
    {
        this("MetroCard",0);
    }

    public MetrocardData(String name, int balance)
    {
        this.name = name;
        this.balance = balance;
    }


    public Date getExpiration() {
        return expiration;
    }

    public int getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public void setName(String name) {
        this.name = name;
    }

}
