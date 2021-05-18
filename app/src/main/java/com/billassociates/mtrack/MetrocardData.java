package com.billassociates.mtrack;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import java.util.Date;

public class MetrocardData implements Parcelable {
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


    protected MetrocardData(Parcel in) {
        name = in.readString();
        balance = in.readInt();
        image = in.readString();
    }

    public static final Creator<MetrocardData> CREATOR = new Creator<MetrocardData>() {
        @Override
        public MetrocardData createFromParcel(Parcel in) {
            return new MetrocardData(in);
        }

        @Override
        public MetrocardData[] newArray(int size) {
            return new MetrocardData[size];
        }
    };

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(balance);
        dest.writeString(image);
    }
}
