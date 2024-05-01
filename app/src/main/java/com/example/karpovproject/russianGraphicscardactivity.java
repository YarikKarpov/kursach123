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

public class russianGraphicscardactivity extends AppCompatActivity {

    ListView listView;

String[]graphics={"NVIDIA GEFORCE GTX 1660 SUPER","NVIDIA GEFORCE RTX 4060 ","AMD RADEON RX 6600" };
int[]graphicsimage={R.drawable.gtx1660super,R.drawable.rtx4060,R.drawable.rx6600};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_russian_graphicscardactivity);

        listView=(ListView)findViewById(R.id.listview3);
        CustomBaseAdapter customBaseAdapter3=new CustomBaseAdapter(getApplicationContext(),graphics,graphicsimage);
        listView.setAdapter(customBaseAdapter3);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent intent = new Intent(russianGraphicscardactivity.this, gtx1660super.class);
                    startActivity(intent);
                    finish();
                } else if (position == 1) {
                    Intent intent = new Intent(russianGraphicscardactivity.this, rtx4060.class);
                    startActivity(intent);
                    finish();
                } else if (position == 2) {
                    Intent intent = new Intent(russianGraphicscardactivity.this, rx6600.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}