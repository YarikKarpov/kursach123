package com.example.karpovproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class russianactivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ImageButton russianmotherboard, processorrussianbutton, graphicrussianbutton, powerrussianbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_russianactivity);

        bottomNavigationView=findViewById(R.id.navigationmenu);
        russianmotherboard = findViewById(R.id.buttonrussianmotherboard);
        processorrussianbutton = findViewById(R.id.processorrussianbutton);
       graphicrussianbutton = findViewById(R.id.graphicrussianbutton);
        powerrussianbutton = findViewById(R.id.powerrussianbutton);



        powerrussianbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(russianactivity.this, powerrussianactivity.class);
                startActivity(intent);
            }
        });

        graphicrussianbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(russianactivity.this, russianGraphicscardactivity.class);
                startActivity(intent);
            }
        });

        processorrussianbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(russianactivity.this, processorrussianactivity.class);
                startActivity(intent);
            }
        });

        russianmotherboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(russianactivity.this, motherboardrussianacitvity.class);
                startActivity(intent);
            }
        });

        bottomNavigationView = findViewById(R.id.navigationmenu);
        bottomNavigationView.setSelectedItemId(R.id.settings);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnItemSelectedListener(item -> {

            int itemid = item.getItemId();

            if (itemid == R.id.home){
                return true;
            }else if (itemid == R.id.settings){
                startActivity(new Intent(russianactivity.this, settingsActivity.class));
                return true;
            }
            return false;
        });
    }
}


