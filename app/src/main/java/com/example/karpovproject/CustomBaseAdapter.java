package com.example.karpovproject;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomBaseAdapter extends BaseAdapter {
Context context;
String motherboards[];
int motherboard[];
LayoutInflater inflater;


    public CustomBaseAdapter(Context ctx, String[]motherboards,int[] motherboard){
        this.context=ctx;
        this.motherboards=motherboards;
        this.motherboard=motherboard;
        inflater=LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return motherboards.length;
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
       convertView=inflater.inflate(R.layout.activity_motherboardrussianacitvity,null);
        TextView textView=(TextView) convertView.findViewById(R.id.textView);
        ImageView imageView=(ImageView) convertView.findViewById(R.id.imageView2);
        textView.setText(motherboards[position]);
        imageView.setImageResource(motherboard[position]);
        return convertView;
    }

}
