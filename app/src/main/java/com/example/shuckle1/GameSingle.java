package com.example.shuckle1;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class GameSingle extends AppCompatActivity {
    static int count = 0;
    static int correct = 0;
    MediaPlayer mp = new MediaPlayer();
    Random rand = new Random();
    int answer;
    static boolean valid = false;
    static boolean finished = false;
    public TextView infoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (finished == true) {
            finished = false;
            valid = false;
            correct = 0;
            count = 0;
        }
        if (valid == true) {
            setContentView(R.layout.record_single);
            GifImageView ImageView = findViewById(R.id.imageView);
            try {
                GifDrawable gifDrawable = new GifDrawable(getResources(), R.drawable.shuckle2);
                ImageView.setImageDrawable(gifDrawable);
            } catch (Exception e) {
                e.printStackTrace();
            }
            infoTextView = (TextView) findViewById(R.id.textView2);
            infoTextView.setTextAppearance(getApplicationContext(),
                    R.style.RecordStyle);
            finished = true;
            TextView cor = (TextView) findViewById(R.id.Record1);
            cor.setText(Integer.toString(correct));
            Button button_MAIN1 = (Button) findViewById(R.id.button_MAIN1);
            button_MAIN1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    finish();
                    Intent myIntent = new Intent(GameSingle.this, MainActivity.class);
                    startActivity(myIntent);
                    finish();
                }
            });

        } else {
            setContentView(R.layout.single_game);
            TextView counter = (TextView) findViewById(R.id.counter);
            counter.setText("Stage " + (count + 1));

            final Button button_DO = (Button) findViewById(R.id.button_DO);
            final Button button_DI = (Button) findViewById(R.id.button_DI);
            final Button button_RE = (Button) findViewById(R.id.button_RE);
            final Button button_RI = (Button) findViewById(R.id.button_RI);
            final Button button_MI = (Button) findViewById(R.id.button_MI);
            final Button button_FA = (Button) findViewById(R.id.button_FA);
            final Button button_FI = (Button) findViewById(R.id.button_FI);
            final Button button_SOL = (Button) findViewById(R.id.button_SOL);
            final Button button_SI = (Button) findViewById(R.id.button_SI);
            final Button button_LA = (Button) findViewById(R.id.button_LA);
            final Button button_LI = (Button) findViewById(R.id.button_LI);
            final Button button_TI = (Button) findViewById(R.id.button_TI);
            final Button button_START = (Button) findViewById(R.id.button_START);
            final Button button_NEXT = (Button) findViewById(R.id.button_NEXT);

            final Button Array[] = new Button[12];
            Array[0] = button_DO;
            Array[1] = button_DI;
            Array[2] = button_RE;
            Array[3] = button_RI;
            Array[4] = button_MI;
            Array[5] = button_FA;
            Array[6] = button_FI;
            Array[7] = button_SOL;
            Array[8] = button_SI;
            Array[9] = button_LA;
            Array[10] = button_LI;
            Array[11] = button_TI;

            answer = rand.nextInt(12);
            play(answer);
            Log.d("Game", String.valueOf(answer));
            button_NEXT.setEnabled(false);


            button_DO.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    play(0);
                    for (int i = 0; i < 12; i++) {
                        Array[i].setEnabled(false);
                    }
                    button_NEXT.setEnabled(true);
                    if (answer == 0) {
                        button_DO.setBackgroundColor(Color.GREEN);
                        correct += 1;
                    } else {
                        button_DO.setBackgroundColor(Color.RED);
                        valid = true;
                        button_NEXT.setText("Game Over");
                        button_NEXT.setBackgroundResource(R.drawable.buttonshape2);
                    }
                    count++;
                }
            });

            button_DI.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    play(1);
                    for (int i = 0; i < 12; i++) {
                        Array[i].setEnabled(false);
                    }
                    button_NEXT.setEnabled(true);
                    if (answer == 1) {
                        button_DI.setBackgroundColor(Color.GREEN);
                        correct += 1;
                    } else {
                        button_DI.setBackgroundColor(Color.RED);
                        valid = true;
                        button_NEXT.setText("Game Over");
                        button_NEXT.setBackgroundResource(R.drawable.buttonshape2);
                    }
                    count++;

                }
            });

            button_RE.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    play(2);
                    for (int i = 0; i < 12; i++) {
                        Array[i].setEnabled(false);
                    }
                    button_NEXT.setEnabled(true);
                    if (answer == 2) {

                        button_RE.setBackgroundColor(Color.GREEN);
                        correct += 1;
                    } else {
                        button_RE.setBackgroundColor(Color.RED);
                        valid = true;
                        button_NEXT.setText("Game Over");
                        button_NEXT.setBackgroundResource(R.drawable.buttonshape2);
                    }
                    count++;
                }
            });

            button_RI.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    play(3);
                    for (int i = 0; i < 12; i++) {
                        Array[i].setEnabled(false);
                    }
                    button_NEXT.setEnabled(true);
                    if (answer == 3) {

                        button_RI.setBackgroundColor(Color.GREEN);
                        correct += 1;
                    } else {
                        button_RI.setBackgroundColor(Color.RED);
                        valid = true;
                        button_NEXT.setText("Game Over");
                        button_NEXT.setBackgroundResource(R.drawable.buttonshape2);
                    }
                    count++;
                }
            });

            button_MI.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    play(4);
                    for (int i = 0; i < 12; i++) {
                        Array[i].setEnabled(false);
                    }
                    button_NEXT.setEnabled(true);
                    if (answer == 4) {

                        button_MI.setBackgroundColor(Color.GREEN);
                        correct += 1;
                    } else {
                        button_MI.setBackgroundColor(Color.RED);
                        valid = true;
                        button_NEXT.setText("Game Over");
                        button_NEXT.setBackgroundResource(R.drawable.buttonshape2);
                    }
                    count++;
                }
            });

            button_FA.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    play(5);
                    for (int i = 0; i < 12; i++) {
                        Array[i].setEnabled(false);
                    }
                    button_NEXT.setEnabled(true);
                    if (answer == 5) {

                        button_FA.setBackgroundColor(Color.GREEN);
                        correct += 1;
                    } else {
                        button_FA.setBackgroundColor(Color.RED);
                        valid = true;
                        button_NEXT.setText("Game Over");
                        button_NEXT.setBackgroundResource(R.drawable.buttonshape2);
                    }
                    count++;
                }
            });

            button_FI.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    play(6);
                    for (int i = 0; i < 12; i++) {
                        Array[i].setEnabled(false);
                    }
                    button_NEXT.setEnabled(true);
                    if (answer == 6) {

                        button_FI.setBackgroundColor(Color.GREEN);
                        correct += 1;
                    } else {
                        button_FI.setBackgroundColor(Color.RED);
                        valid = true;
                        button_NEXT.setText("Game Over");
                        button_NEXT.setBackgroundResource(R.drawable.buttonshape2);
                    }
                    count++;
                }
            });

            button_SOL.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    play(7);
                    for (int i = 0; i < 12; i++) {
                        Array[i].setEnabled(false);
                    }
                    button_NEXT.setEnabled(true);
                    if (answer == 7) {

                        button_SOL.setBackgroundColor(Color.GREEN);
                        correct += 1;
                    } else {
                        button_SOL.setBackgroundColor(Color.RED);
                        valid = true;
                        button_NEXT.setText("Game Over");
                        button_NEXT.setBackgroundResource(R.drawable.buttonshape2);
                    }
                    count++;
                }
            });

            button_SI.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    play(8);
                    for (int i = 0; i < 12; i++) {
                        Array[i].setEnabled(false);
                    }
                    button_NEXT.setEnabled(true);
                    if (answer == 8) {

                        button_SI.setBackgroundColor(Color.GREEN);
                        correct += 1;
                    } else {
                        button_SI.setBackgroundColor(Color.RED);
                        valid = true;
                        button_NEXT.setText("Game Over");
                        button_NEXT.setBackgroundResource(R.drawable.buttonshape2);
                    }
                    count++;
                }
            });

            button_LA.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    play(9);
                    for (int i = 0; i < 12; i++) {
                        Array[i].setEnabled(false);
                    }
                    button_NEXT.setEnabled(true);
                    if (answer == 9) {

                        button_LA.setBackgroundColor(Color.GREEN);
                        correct += 1;
                    } else {
                        button_LA.setBackgroundColor(Color.RED);
                        valid = true;
                        button_NEXT.setText("Game Over");
                        button_NEXT.setBackgroundResource(R.drawable.buttonshape2);
                    }
                    count++;
                }
            });

            button_LI.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    play(10);
                    for (int i = 0; i < 12; i++) {
                        Array[i].setEnabled(false);
                    }
                    button_NEXT.setEnabled(true);
                    if (answer == 10) {

                        button_LI.setBackgroundColor(Color.GREEN);
                        correct += 1;
                    } else {
                        button_LI.setBackgroundColor(Color.RED);
                        valid = true;
                        button_NEXT.setText("Game Over");
                        button_NEXT.setBackgroundResource(R.drawable.buttonshape2);
                    }
                    count++;
                }
            });

            button_TI.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    play(11);
                    for (int i = 0; i < 12; i++) {
                        Array[i].setEnabled(false);
                    }
                    button_NEXT.setEnabled(true);
                    if (answer == 11) {

                        button_TI.setBackgroundColor(Color.GREEN);
                        correct += 1;
                    } else {
                        button_TI.setBackgroundColor(Color.RED);
                        valid = true;
                        button_NEXT.setText("Game Over");
                        button_NEXT.setBackgroundResource(R.drawable.buttonshape2);
                    }
                    count++;
                }
            });

            button_START.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    play(answer);
                }

            });
            button_NEXT.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mp.release();
                    Intent myIntent = new Intent(GameSingle.this, GameSingle.class);
                    startActivity(myIntent);
                    finish();
                }
            });
            infoTextView = (TextView) findViewById(R.id.counter);
            infoTextView.setTextAppearance(getApplicationContext(),
                    R.style.AudioFileInfoOverlayText);
        }
    }

    void play(int pitch) {
        mp.release();
        switch (pitch) {
            case 0:
                mp = MediaPlayer.create(getApplicationContext(), R.raw.doo);
                mp.start();
                break;
            case 1:
                mp = MediaPlayer.create(getApplicationContext(), R.raw.di);
                mp.start();
                break;
            case 2:
                mp = MediaPlayer.create(getApplicationContext(), R.raw.re);
                mp.start();
                break;
            case 3:
                mp = MediaPlayer.create(getApplicationContext(), R.raw.ri);
                mp.start();
                break;
            case 4:
                mp = MediaPlayer.create(getApplicationContext(), R.raw.mi);
                mp.start();
                break;
            case 5:
                mp = MediaPlayer.create(getApplicationContext(), R.raw.fa);
                mp.start();
                break;
            case 6:
                mp = MediaPlayer.create(getApplicationContext(), R.raw.fi);
                mp.start();
                break;
            case 7:
                mp = MediaPlayer.create(getApplicationContext(), R.raw.sol);
                mp.start();
                break;
            case 8:
                mp = MediaPlayer.create(getApplicationContext(), R.raw.si);
                mp.start();
                break;
            case 9:
                mp = MediaPlayer.create(getApplicationContext(), R.raw.la);
                mp.start();
                break;
            case 10:
                mp = MediaPlayer.create(getApplicationContext(), R.raw.li);
                mp.start();
                break;
            case 11:
                mp = MediaPlayer.create(getApplicationContext(), R.raw.ti);
                mp.start();
                break;

        }
    }


}

