package com.alctrain.android.afinally;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Goods extends AppCompatActivity {

    private String name;
    private int imageId;
    private int goodId;
    private int goodpaid;
    public Goods(String name,int imageId,int goodId,int goodpaid){
        this.name = name;
        this.imageId = imageId;
        this.goodId=goodId;
        this.goodpaid=goodpaid;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
    }
}
