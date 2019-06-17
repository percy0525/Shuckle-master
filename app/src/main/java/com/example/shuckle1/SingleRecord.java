package com.example.shuckle1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class SingleRecord extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record_single);
        GifImageView ImageView = findViewById(R.id.imageView);
        try {
            GifDrawable gifDrawable = new GifDrawable(getResources(), R.drawable.shuckle2);
            ImageView.setImageDrawable(gifDrawable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
