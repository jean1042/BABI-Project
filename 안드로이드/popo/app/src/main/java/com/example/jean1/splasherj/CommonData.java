package com.example.jean1.splasherj;

import android.app.Application;

public class CommonData extends Application {

    public String data;

    public String getData(){
        return data;
    }

    public void setData(String s){
        this.data=s;
    }
}
