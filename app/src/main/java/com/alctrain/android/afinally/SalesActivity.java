package com.alctrain.android.afinally;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

public class SalesActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sales);
        String[] list_data = {"one","tow","three","four"};
        int msgWhat = 3;
        MyHandler handler;
        ListAdapter adapter = new ArrayAdapter<String>(SalesActivity.this,android.R.layout.simple_list_item_1,list_data);
        setListAdapter(adapter);

    }
}
