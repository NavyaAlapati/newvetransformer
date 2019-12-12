package com.mmg.vetransformers.commonutiles;

import android.app.Application;

import java.util.ArrayList;

public class Global_Access extends Application {
    private static Global_Access ourInstance = new Global_Access();

    public static Global_Access getInstance() {
        return ourInstance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;
    String name;
    String mobilenumber;
    String amount;
    String email;
    String others;

    public static Global_Access getOurInstance() {
        return ourInstance;
    }

    public static void setOurInstance(Global_Access ourInstance) {
        Global_Access.ourInstance = ourInstance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }
}
