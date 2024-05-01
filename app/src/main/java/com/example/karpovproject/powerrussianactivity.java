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

public class powerrussianactivity extends AppCompatActivity {

    ListView listView;
    String [] power={"Cougar VTE 600","Aerocool KCAS-650GM","Thermaltake smart DPS 600W"};
    int [] powerimage={R.drawable.vte600,R.drawable.kcas,R.drawable.dps600w};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_powerrussianactivity);


        listView=(ListView)findViewById(R.id.listview4);
        CustomBaseAdapter customBaseAdapter4=new CustomBaseAdapter(getApplicationContext(),power,powerimage);
        listView.setAdapter(customBaseAdapter4);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent intent = new Intent(powerrussianactivity.this, VTX600.class);
                    startActivity(intent);
                    finish();
                } else if (position == 1) {
                    Intent intent = new Intent(powerrussianactivity.this, KCAS.class);
                    startActivity(intent);
                    finish();
                } else if (position == 2) {
                    Intent intent = new Intent(powerrussianactivity.this, smart600.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}