package com.alctrain.android.afinally;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.*;

public class MainActivity extends AppCompatActivity implements Runnable {
    MyHandler handler;
    String id;
    String pwd;
    String a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        handler=new MyHandler();
    }
    public  void loginclick(View btn){
        EditText userid=(EditText) findViewById(R.id.finduserid);
        id=userid.getText().toString();
        EditText userpwd=(EditText) findViewById(R.id.finduserphone);
        pwd=userpwd.getText().toString();
        Thread t = new Thread(this);
        t.start();
        boolean b=handler.panduan();
        if(b){
            Log.i("a","判断为真");
            Intent sales=new Intent(this,SalesActivity.class);
            startActivityForResult(sales,1);
        }else {
            Log.i("b","判断为假");
            Toast.makeText(this,"请重新输入",Toast.LENGTH_SHORT).show();
        }
    }
    public void findclick(View btn){
        Intent find=new Intent(this,FindActivity.class);
        startActivityForResult(find,1);
    }


    public void regisclick(View btn){
        Intent regis=new Intent(this,RegisActivity.class);
        startActivityForResult(regis,1);
    }






    @Override
    public void run() {
        try {
            Log.i("das","子线程开启正常");
            Class.forName("com.mysql.jdbc.Driver");
            Log.i("dass","查找驱动正常");
            Connection conn= DriverManager.getConnection("jdbc:mysql://10.43.102.212:3306/jsp_final", "root", "wnj123456");//远程链接地址，用户名，密码
            Log.i("dasss","成功来链接数据库");
            Statement stmt=conn.createStatement();
            String sql="select * from users where Username='"+id+"' and Userpwd='"+pwd+"'";
            Log.i("id:",id);
            Log.i("pwd:",pwd);
            ResultSet rs=stmt.executeQuery(sql);
            Log.i("dassss","成功查询数据库");
            if(rs.next()){
                a="true";
            }else{
                a="false";
            }
            Log.i("a:",a);
            rs.close();
            stmt.close();
            conn.close();
            Message msg = handler.obtainMessage(5);
            msg.obj=a;
            handler.sendMessage(msg);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
