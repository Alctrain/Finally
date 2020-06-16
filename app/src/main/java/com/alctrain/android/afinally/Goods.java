package com.alctrain.android.afinally;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Goods extends AppCompatActivity {

    private String name;
    private int imageId;
    private int goodId;
    private int goodpaid;
    private boolean select;
    public Goods(String name,int imageId,int goodId,int goodpaid){
        this.name = name;
        this.imageId = imageId;
        this.goodId=goodId;
        this.goodpaid=goodpaid;
    }

    public void setSelect(boolean s) {
        this.select=s;
    }
    public String getName(){
        return name;
    }

    public int getImageId() {
        return imageId;
    }
    public int getgoodId() {
        return goodId;
    }
    public int getGoodpaid() {
        return goodpaid;
    }

    public boolean getSelect() {
        return select;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
    }

}