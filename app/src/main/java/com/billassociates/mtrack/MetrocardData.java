package com.billassociates.mtrack;

import android.support.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class MetrocardData {
    private String name;
    private int balance;
    private Date expiration;
    String image;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @NonNull
    @NotNull
    @Override
    public String toString() {
        return this.name +
                ": " +
                Double.toString(this.balance);
    }

    public int addBal(int bal)
    {
        return this.balance += bal;
    }

    public int subBal(int bal) throws Exception
    {
        if (this.balance - bal < 0)
        {
            throw new Exception("Balance below zero!");
        }
        return this.balance -= bal;
    }



}
