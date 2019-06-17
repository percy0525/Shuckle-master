package com.example.shuckle1;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button singlebutton = (Button) findViewById(R.id.button_single);
        Button doublebutton = (Button) findViewById(R.id.button_double);
        Button thirdbutton = (Button) findViewById(R.id.button_triple);
        GifImageView ImageView = findViewById(R.id.imageView);
        try {
            GifDrawable gifDrawable = new GifDrawable(getResources(), R.drawable.shuckle1);
            ImageView.setImageDrawable(gifDrawable);
        } catch (Exception e) {
            e.printStackTrace();
        }

        singlebutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, GameSingle.class);
                startActivity(intent);
            }
        });
        doublebutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, GameDouble.class);
                startActivity(intent);
            }
        });
        thirdbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, GameThird.class);
                startActivity(intent);
            }
        });
    }
}
