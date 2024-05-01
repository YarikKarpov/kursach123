package com.example.lb14;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private MediaPlayer mediaPlayer2;
    private SharedPreferences sharedPreferences;

    private static final String FILE_NAME="file.txt";

    ConstraintLayout layout;
    Button button;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;

    TextView textView;
    SeekBar seekBar;


    int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.main);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String color = sharedPreferences.getString("color", "#FFFFFF");
        findViewById(android.R.id.content).setBackgroundColor(Color.parseColor(color));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setBackgroundColor(Color.RED);
                sharedPreferences.edit().putString("color", "#FF0000").apply();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setBackgroundColor(Color.GREEN);
                sharedPreferences.edit().putString("color", "#00FF00").apply();

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setBackgroundColor(Color.YELLOW);
                sharedPreferences.edit().putString("color", "#FFFF00").apply();
            }
        });
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(images[0]);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int randomImage = random.nextInt(images.length);
                imageView.setImageResource(images[randomImage]);
            }
        });
        mediaPlayer = MediaPlayer.create(this, R.raw.vistrel);
        button4 = findViewById(R.id.button4);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.gudok);
        button5 = findViewById(R.id.button5);
        button6=findViewById(R.id.button6);
        seekBar=findViewById(R.id.seekBar);
        button7=findViewById(R.id.button7);
        textView=findViewById(R.id.textView);


        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int randomNumber=random.nextInt(1000)+1;
                textView.setText(String.valueOf(randomNumber));
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float volume = (float) (1-(Math.log(100-progress)/ Math.log(100)));
                mediaPlayer.setVolume(volume, volume);
                mediaPlayer2.setVolume(volume, volume);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


    public void playSound(View view) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        } else {
            mediaPlayer.start();
        }


    }
    public void playSound2 (View view) {
        if (mediaPlayer2.isPlaying()) {
            mediaPlayer2.pause();
        } else {
            mediaPlayer2.start();
        }
    }
    public void playSound3 (View view) {
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.release();
            }
        });
        mediaPlayer2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer2.release();
            }
        });
        mediaPlayer.start();
        mediaPlayer2.start();
    }
    }



