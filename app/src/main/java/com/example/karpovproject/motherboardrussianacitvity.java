package com.example.karpovproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class motherboardrussianacitvity extends AppCompatActivity {

    String[] motherboards= {"Gigabyte B760m Gaming DDR4 ","ASUS PRIME B450M-A", "MSI B650 TOMAHAWK WIFI","ASRock B760M Pro RS"};

    ListView listView;
    TextView textView;
    CustomBaseAdapter customBaseAdapter;


    int motherboard[]={R.drawable.b760m, R.drawable.b450m_a,R.drawable.b650,R.drawable.asrock_b760m};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_motherboardrussianacitvity);

        listView=(ListView)findViewById(R.id.listview2);
        customBaseAdapter=new CustomBaseAdapter(getApplicationContext(),motherboards, motherboard);
        listView.setAdapter(customBaseAdapter);
        textView=findViewById(R.id.textb660);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position==0){
                    Intent intent=new Intent(motherboardrussianacitvity.this, b660m.class);
                    startActivity(intent);
                    finish();
                }else if(position==1) {
                    Intent intent = new Intent(motherboardrussianacitvity.this, b450m.class);
                    startActivity(intent);
                    finish();
                }else if(position==2){
                    Intent intent = new Intent(motherboardrussianacitvity.this, b650.class);
                    startActivity(intent);
                    finish();
                }else if(position==3){
                    Intent intent = new Intent(motherboardrussianacitvity.this, b760m.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}