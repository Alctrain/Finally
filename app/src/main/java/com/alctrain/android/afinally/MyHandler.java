package com.alctrain.android.afinally;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class MyHandler extends Handler {
    int a;
    @Override

    public void handleMessage(Message msg) {
        if(msg.what==5){
            String str = (String) msg.obj;
            if ("true".equals(str)){
                 a=1;
            }else if("false".equals(str)){
                a=0;
            }
        }
        if(msg.what==4){
            String str = (String) msg.obj;
            if ("true".equals(str)){
                a=1;
            }else if("false".equals(str)){
                a=0;
            }
        }
        super.handleMessage(msg);

    }
    public boolean panduan(){
        if(a==1){
            return true;

        }else {
            return false;
        }
    }
}
