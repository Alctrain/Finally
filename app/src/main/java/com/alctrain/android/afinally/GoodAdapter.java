package com.alctrain.android.afinally;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class GoodAdapter extends ArrayAdapter {
    private int resourceId;
    public GoodAdapter(Context context, int textViewResourceId, List<Goods> objects) {
        super(context,  textViewResourceId,objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Goods good = (Goods)getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        ImageView goodImage = (ImageView) view.findViewById(R.id.good_image);
        TextView goodName = (TextView) view.findViewById(R.id.good_name);
        TextView goodpaid = (TextView) view.findViewById(R.id.goodspaid);
        Button goodadd = (Button) view.findViewById(R.id.button2);
        goodImage.setImageResource(good.getImageId());
        int a=good.getGoodpaid();
        String s=String.valueOf(a)+"元";
        goodpaid.setText(s);
        goodName.setText(good.getName());
        return  view;
    }

}
