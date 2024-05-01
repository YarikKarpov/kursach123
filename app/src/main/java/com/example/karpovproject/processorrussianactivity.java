package com.example.karpovproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class processorrussianactivity extends AppCompatActivity {

ListView listView;
    String[]processors={"Intel Core I5 12400F","Intel Core I9 14900KF","AMD Ryzen 5600X"};
    int[]processor={R.drawable.i512400f,R.drawable.i914900kf,R.drawable.ryzen55600x};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_processorrussianactivity);

        listView=(ListView)findViewById(R.id.listview2);
        CustomBaseAdapter customBaseAdapter2=new CustomBaseAdapter(getApplicationContext(),processors,processor);
        listView.setAdapter(customBaseAdapter2);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent intent = new Intent(processorrussianactivity.this, i512400f.class);
                    startActivity(intent);
                    finish();
                } else if (position == 1) {
                    Intent intent = new Intent(processorrussianactivity.this, i914900kf.class);
                    startActivity(intent);
                    finish();
                } else if (position == 2) {
                    Intent intent = new Intent(processorrussianactivity.this, ryzen5600x.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}