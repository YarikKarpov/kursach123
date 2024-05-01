package com.example.karpovproject;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.lang.reflect.Field;

public class regisetractivity extends AppCompatActivity {

    TextInputEditText editTextemail, editTextpassword;
    FirebaseAuth mauth;

    TextView loginbutton1;
    Button registerbutton1;

    @Override
    public void onStart() {
        super.onStart();

        FirebaseUser currentUser = mauth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), russianactivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_regisetractivity);
        mauth= FirebaseAuth.getInstance();
        editTextemail=findViewById(R.id.email);
        editTextpassword=findViewById(R.id.password);
        loginbutton1=findViewById(R.id.loginbutton1);
        registerbutton1=findViewById(R.id.registerbutton1);

        registerbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, password;
                email = String.valueOf(editTextemail.getText());
                password = String.valueOf(editTextpassword.getText());

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(regisetractivity.this, "Введите почту", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(regisetractivity.this, "Введите пароль", Toast.LENGTH_SHORT).show();
                    return;
                }
                mauth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(regisetractivity.this, "Регистрация успешна",
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(regisetractivity.this, "Ошибка регистрации",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
        loginbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(regisetractivity.this, autorisationactivity.class);
                startActivity(intent);
            }
        });

    }
}
