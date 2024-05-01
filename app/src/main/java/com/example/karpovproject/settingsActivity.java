package com.example.karpovproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class settingsActivity extends AppCompatActivity {


    FirebaseAuth auth;
    FirebaseUser user;
    ImageButton logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings);

        logout=findViewById(R.id.logoutbutton);



        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(settingsActivity.this, autorisationactivity.class);
                startActivity(intent);
                finish();
            }
        });
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationmenu);
        bottomNavigationView.setSelectedItemId(R.id.settings);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnItemSelectedListener(item -> {


        int itemid = item.getItemId();

        if (itemid == R.id.settings){
            return true;
        }else if (itemid == R.id.home){
            startActivity(new Intent(settingsActivity.this, russianactivity.class));
            return true;
        }
        return false;
    });
    }
}