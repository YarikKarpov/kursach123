package com.example.karpovproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomBaseAdapter3 extends BaseAdapter {
    Context context;
    String[]graphics;
    int[]graphicsimage;
    LayoutInflater inflater;
    public CustomBaseAdapter3(Context context, String []graphics,int []graphicsimage){
        this.context=context;
        this.graphics=graphics;
        this.graphicsimage=graphicsimage;
        inflater=LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return graphics.length;
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
        convertView=inflater.inflate(R.layout.activity_russian_graphicscardactivity,null);
        TextView textView=(TextView) convertView.findViewById(R.id.textView3);
        ImageView imageView=(ImageView) convertView.findViewById(R.id.imageView4);
        textView.setText(graphics[position]);
        imageView.setImageResource(graphicsimage[position]);
        return convertView;
    }
}
