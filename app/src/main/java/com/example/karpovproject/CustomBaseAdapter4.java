package com.example.karpovproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomBaseAdapter4 extends BaseAdapter {
    Context context;
    String[]power;
    int[]powerimage;
    LayoutInflater inflater;
    public CustomBaseAdapter4(Context context, String []power,int []powerimage){
        this.context=context;
        this.power=power;
        this.powerimage=powerimage;
        inflater=LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return power.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.activity_powerrussianactivity,null);
        TextView textView=(TextView) convertView.findViewById(R.id.textView4);
        ImageView imageView=(ImageView) convertView.findViewById(R.id.imageView5);
        textView.setText(power[position]);
        imageView.setImageResource(powerimage[position]);
        return convertView;
    }
}


