package com.example.karpovproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomBaseAdapter2 extends BaseAdapter {
    Context context;
    String[]processors;
    int[]processor;
    LayoutInflater inflater;
    public CustomBaseAdapter2(Context context, String []processors,int []processor){
        this.context=context;
        this.processors=processors;
        this.processor=processor;
        inflater=LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return processors.length;
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
        convertView=inflater.inflate(R.layout.activity_processorrussianactivity,null);
        TextView textView=(TextView) convertView.findViewById(R.id.textVie2);
        ImageView imageView=(ImageView) convertView.findViewById(R.id.imageView3);
        textView.setText(processors[position]);
        imageView.setImageResource(processor[position]);
        return convertView;
    }
}
