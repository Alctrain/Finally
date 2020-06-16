package com.alctrain.android.afinally;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GoodAdapter extends ArrayAdapter {
    private int resourceId;
    List<Goods>  listdata;
    HashMap<Integer,Boolean> state=new HashMap<Integer,Boolean>();
    public GoodAdapter(Context context, int textViewResourceId, List<Goods> objects) {
        super(context,  textViewResourceId,objects);
        resourceId = textViewResourceId;
        listdata=objects;
    }
    @Override
    public int getCount(){
        return listdata.size();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Goods good = (Goods)getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        ImageView goodImage = (ImageView) view.findViewById(R.id.good_image);
        TextView goodName = (TextView) view.findViewById(R.id.good_name);
        TextView goodpaid = (TextView) view.findViewById(R.id.goodspaid);
        CheckBox select=(CheckBox) view.findViewById(R.id.checkBox) ;
        goodImage.setImageResource(good.getImageId());
        int a=good.getGoodpaid();
        String s=String.valueOf(a)+"元";
        goodpaid.setText(s);
        goodName.setText(good.getName());
        select.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    state.put(position, isChecked);
                }else{
                    state.remove(position);
                }
            }
        });

        select.setChecked((state.get(position)==null ? false : true));


        return  view;

    }

}
