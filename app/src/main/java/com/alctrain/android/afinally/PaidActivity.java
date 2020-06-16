package com.alctrain.android.afinally;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class PaidActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paid);
        TextView a1=(TextView) findViewById(R.id.paydescribe1);
        TextView a2=(TextView) findViewById(R.id.paydescribe2);
        Intent intent = getIntent();

        int num = intent.getIntExtra("num",0);
        float paid = intent.getIntExtra("paid",0);
        String a=String.valueOf(num);
        String b =String.valueOf(paid);
        String d1="您一共购买了"+a+"件商品";
        String d2="一共需要支付"+b+"元";
        a1.setText(d1);
        a2.setText(d2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menu_set){
            Intent config = new Intent(this, GouwuActivity.class);
            startActivity(config);
        }

        return super.onOptionsItemSelected(item);
    }

    public void finalpayclick(View btn){
        Toast.makeText(this,"付款成功",Toast.LENGTH_SHORT).show();
    }
}
