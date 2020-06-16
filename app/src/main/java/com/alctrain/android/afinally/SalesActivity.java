package com.alctrain.android.afinally;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
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

public class SalesActivity extends ListActivity {
    GoodAdapter adapter;
    private List goodsList = new ArrayList();
    ArrayList<Integer> list=new ArrayList<Integer>();



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menu_set){
            //点击后的事件处理，可填入打开配置汇率页面的代码
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sales);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        initGoods();
        adapter = new GoodAdapter(this,R.layout.activity_goods,goodsList);
        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(adapter);
    }





    public void addclick(View v){
        String xianshi="";
        int paid=0;
        HashMap<Integer,Boolean> state=adapter.state;
        for(int j=0;j<=adapter.getCount();j++){
            if(state.get(j)!=null){
                Goods a=(Goods) goodsList.get(j);
                paid=paid+a.getGoodpaid();
                String b=String.valueOf(a.getGoodpaid());
                xianshi=xianshi+"jainge"+b;
                list.add(j+1);
            }
        }
        Log.i("frstsale", String.valueOf(list.get(0)));
        Intent config = new Intent(this, GouwuActivity.class);
        config.putExtra("which",list);
        startActivityForResult(config,1);
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




//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == R.id.menu_set) {
//            Intent config = new Intent(this, GouwuActivity.class);
//            startActivity(config);
//        }
//        return super.onOptionsItemSelected(item);
//    }
    private void initGoods() {
        Goods bf1 = new Goods("小黄鸡",R.drawable.diyi,1,3);
        goodsList.add(bf1);
        Goods bf4 = new Goods("哭黄鸡",R.drawable.dier,2,5);
        goodsList.add(bf4);
        Goods bf2 = new Goods("吃瓜",R.drawable.disan,3,10);
        goodsList.add(bf2);
        Goods bf3 = new Goods("委屈",R.drawable.disi,4,2);
        goodsList.add(bf3);
        Goods bf5 = new Goods("鄙视",R.drawable.diwu,5,5);
        goodsList.add(bf5);
        Goods bf6 = new Goods("哭泣",R.drawable.diliu,6,6);
        goodsList.add(bf6);
        Goods bf7 = new Goods("吃手",R.drawable.diqi,7,94);
        goodsList.add(bf7);
        Goods bf8 = new Goods("哭泣",R.drawable.diba,8,55);
        goodsList.add(bf8);
        Goods bf9 = new Goods("嗯哼？",R.drawable.dijiu,9,56);
        goodsList.add(bf9);
        Goods bf10 = new Goods("喝雪碧",R.drawable.shi,10,6);
        goodsList.add(bf10);
        Goods bf11 = new Goods("锤击",R.drawable.shiyi,11,34);
        goodsList.add(bf11);
        Goods bf12 = new Goods("感动",R.drawable.shier,12,76);
        goodsList.add(bf12);
        Goods bf13 = new Goods("威胁",R.drawable.shisan,13,59);
        goodsList.add(bf13);


    }
}
