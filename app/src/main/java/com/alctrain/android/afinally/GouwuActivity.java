package com.alctrain.android.afinally;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GouwuActivity extends ListActivity {

    GoodAdapter adapter;
    private List goodsList = new ArrayList();
    String xianshi="";
    ArrayList<Integer> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gouwu);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        Intent intent = getIntent();
        list=intent.getIntegerArrayListExtra("which");



        initGoods();
        adapter = new GoodAdapter(this,R.layout.activity_goods,goodsList);
        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(adapter);
    }



    public void payclick(View v){

        int paid=0;int num=0;
        HashMap<Integer,Boolean> state=adapter.state;
        for(int j=0;j<=adapter.getCount();j++){
            if(state.get(j)!=null){
                Goods a=(Goods) goodsList.get(j);
                paid=paid+a.getGoodpaid();
                String b=String.valueOf(a.getGoodpaid());
                num++;
            }
        }

        Intent config = new Intent(this, PaidActivity.class);
        config.putExtra("num",num);
        config.putExtra("paid",paid);
        startActivityForResult(config,1);
    }


    private void initGoods() {
        for(int i=0;i<list.size();i++){
            if(list.get(i)==1){
        Goods bf1 = new Goods("小黄鸡",R.drawable.diyi,1,3);
        goodsList.add(bf1);}else if(list.get(i)==2){
        Goods bf4 = new Goods("哭黄鸡",R.drawable.dier,2,5);
        goodsList.add(bf4);}else if(list.get(i)==3){
        Goods bf2 = new Goods("吃瓜",R.drawable.disan,3,10);
        goodsList.add(bf2);}else if(list.get(i)==4){
        Goods bf3 = new Goods("委屈",R.drawable.disi,4,2);
        goodsList.add(bf3);}else if(list.get(i)==5){
        Goods bf5 = new Goods("鄙视",R.drawable.diwu,5,5);
        goodsList.add(bf5);}else if(list.get(i)==6){
        Goods bf6 = new Goods("哭泣",R.drawable.diliu,6,6);
        goodsList.add(bf6);}else if(list.get(i)==7){
        Goods bf7 = new Goods("吃手",R.drawable.diqi,7,94);
        goodsList.add(bf7);}else if(list.get(i)==8){
        Goods bf8 = new Goods("哭泣",R.drawable.diba,8,55);
        goodsList.add(bf8);}else if(list.get(i)==9){
        Goods bf9 = new Goods("嗯哼？",R.drawable.dijiu,9,56);
        goodsList.add(bf9);}else if(list.get(i)==10){
        Goods bf10 = new Goods("喝雪碧",R.drawable.shi,10,6);
        goodsList.add(bf10);}else if(list.get(i)==11){
        Goods bf11 = new Goods("锤击",R.drawable.shiyi,11,34);
        goodsList.add(bf11);}else if(list.get(i)==12){
        Goods bf12 = new Goods("感动",R.drawable.shier,12,76);
        goodsList.add(bf12);}else if(list.get(i)==13){
        Goods bf13 = new Goods("威胁",R.drawable.shisan,13,59);
        goodsList.add(bf13);}


    }}
}
