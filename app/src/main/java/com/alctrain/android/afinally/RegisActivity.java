package com.alctrain.android.afinally;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisActivity extends AppCompatActivity implements Runnable {

    MyHandler handler;
    String id;
    String pwd;
    String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        a="false";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        handler=new MyHandler();
    }



    public  void regisedclick(View btn){
        EditText userid=(EditText) findViewById(R.id.finduserid);
        id=userid.getText().toString();
        EditText userpwd=(EditText) findViewById(R.id.finduserphone);
        pwd=userpwd.getText().toString();
        Thread t = new Thread(this);
        t.start();
        boolean b=handler.panduan();
        if(b){
            Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
            Intent sales=new Intent(this,MainActivity.class);
            startActivityForResult(sales,1);
        }else{
            Toast.makeText(this,"请重新输入",Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void run() {
        if((id!=null) && (pwd!=null)){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://192.168.137.1:3306/jsp_final", "root", "wnj123456");//远程链接地址，用户名，密码
            Statement stmt=conn.createStatement();
            String sql="insert into users values('"+id+"','"+pwd+"')";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            Message msg = handler.obtainMessage(4);
            a="true";
            msg.obj=a;
            handler.sendMessage(msg);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }else{Toast.makeText(this,"请重新输入",Toast.LENGTH_SHORT).show();
        }
    }
}
