package com.alctrain.android.afinally;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesActivity extends ListActivity {

    private List goodsList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);
        initGoods();
        GoodAdapter adapter = new GoodAdapter(this,R.layout.activity_goods,goodsList);
        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(adapter);
    }

    private void initGoods() {
        for (int i =0;i<=4;i++){
        Goods bf1 = new Goods("小黄鸡",R.drawable.diyi,1,3);
        goodsList.add(bf1);
        Goods bf4 = new Goods("哭黄鸡",R.drawable.dier,2,5);
        goodsList.add(bf4);
        Goods bf2 = new Goods("吃瓜",R.drawable.disan,3,10);
        goodsList.add(bf2);
        Goods bf3 = new Goods("委屈",R.drawable.disi,4,2);
        goodsList.add(bf3);
        Goods bf5 = new Goods("鄙视",R.drawable.diwu,1,5);
        goodsList.add(bf5);
        Goods bf6 = new Goods("哭泣",R.drawable.diliu,1,6);
        goodsList.add(bf6);
        Goods bf7 = new Goods("吃手",R.drawable.diqi,1,94);
        goodsList.add(bf7);
        Goods bf8 = new Goods("哭泣",R.drawable.diba,1,55);
        goodsList.add(bf8);
        Goods bf9 = new Goods("嗯哼？",R.drawable.dijiu,1,56);
        goodsList.add(bf9);
        Goods bf10 = new Goods("喝雪碧",R.drawable.shi,1,6);
        goodsList.add(bf10);
        Goods bf11 = new Goods("锤击",R.drawable.shiyi,1,34);
        goodsList.add(bf11);
        Goods bf12 = new Goods("感动",R.drawable.shier,1,76);
        goodsList.add(bf12);
        Goods bf13 = new Goods("威胁",R.drawable.shisan,1,59);
        goodsList.add(bf13);


    }}
}
