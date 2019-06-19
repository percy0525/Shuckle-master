////////////////////////////////////////////////////////////////////////////////
//
//  MidiDriver - An Android Midi Driver.
//
//  Copyright (C) 2013	Bill Farmer
//
//  This program is free software; you can redistribute it and/or modify
//  it under the terms of the GNU General Public License as published by
//  the Free Software Foundation; either version 3 of the License, or
//  (at your option) any later version.
//
//  This program is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU General Public License for more details.
//
//  You should have received a copy of the GNU General Public License
//  along with this program.  If not, see <http://www.gnu.org/licenses/>.
//
//  Licensed under the Apache License, Version 2.0 (the "License");
//  you may not use this file except in compliance with the License.
//  You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
//  Unless required by applicable law or agreed to in writing, software
//  distributed under the License is distributed on an "AS IS" BASIS,
//  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//  See the License for the specific language governing permissions and
//  limitations under the License.
//
//  Bill Farmer	 william j farmer [at] yahoo [dot] co [dot] uk.
//
///////////////////////////////////////////////////////////////////////////////

package com.example.shuckle1;

import android.app.Activity;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.marcok.stepprogressbar.StepProgressBar;

public class GameDouble extends Activity
        implements View.OnTouchListener, View.OnClickListener {

    private TextView text;
    private Button btn_sound, bt1, bt2, bt3, bt4;
    public MediaPlayer player;
    public MediaPlayer correctPlayer;
    public StepProgressBar mStepProgressBar;
    public Animation animation;

    String[] answer = {
            "1234",
            "12324",
            "231243",
            "4123342",
            "42312324",};

    int level = 0;
    String tmpString = "";

    // On create
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.double_game);

        // Create midi driver
        btn_sound = findViewById(R.id.soundout);
        mStepProgressBar = (StepProgressBar) findViewById(R.id.stepProgressBar);
        mStepProgressBar.setCumulativeDots(true);
        mStepProgressBar.setCurrentProgressDot(-1);


        // Set on touch listener

        View v = findViewById(R.id.soundout);
        if (v != null)
            v.setOnClickListener(this);
        btn_sound.setOnTouchListener(this);

        text = findViewById(R.id.status);
        text.setText("LEVEL 1");

        bt1 = findViewById(R.id.Do);
        bt2 = findViewById(R.id.Re);
        bt3 = findViewById(R.id.Mi);
        bt4 = findViewById(R.id.Fa);


    }

    // On resume
    @Override
    protected void onResume() {
        super.onResume();
    }

    // On pause
    @Override
    protected void onPause() {
        super.onPause();
        // Stop player
        if (player != null)
            player.stop();
    }


    // On touch

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                btn_sound.setEnabled(false);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            startlevel();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    btn_sound.setEnabled(true);
                                }
                            });

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }).start();
                System.out.println(" pressed ");
                return true;

            case MotionEvent.ACTION_UP:
                System.out.println(" released ");
                return true;
        }
        return false;

    }

    // On click
    @Override
    public void onClick(View v) {

    }

    // Listener for sending initial midi messages when the Sonivox
    // synthesizer has been started, such as program change.
    // Send a midi message, 2 bytes

    public void soundOne(View v) {

        int id = v.getId();

        if (player != null) {
            player.stop();
            player.reset();
            player.release();
            player = null;
        }

        switch (id) {
            case R.id.Do:
                player = MediaPlayer.create(this, R.raw.doo);
                player.start();
                tmpString += "1";
                break;
            case R.id.Re:
                player = MediaPlayer.create(this, R.raw.re);
                player.start();
                tmpString += "2";
                break;
            case R.id.Mi:
                player = MediaPlayer.create(this, R.raw.mi);
                player.start();
                tmpString += "3";
                break;
            case R.id.Fa:
                player = MediaPlayer.create(this, R.raw.fa);
                player.start();
                tmpString += "4";
                break;

        }


        if (answer[level].length() == tmpString.length()) {
            System.out.println(tmpString);
            System.out.println(answer[level]);
            System.out.println(level);
            mStepProgressBar.setCurrentProgressDot(-1);

            if (answer[level].equals(tmpString)) {
                correctPlayer = MediaPlayer.create(this, R.raw.correct);
                correctPlayer.start();
                tmpString = "";
                mStepProgressBar.setNumDots(mStepProgressBar.getNumDots() + 1);
                level += 1;
                text.setText("LEVEL " + (level + 1));
                if (level == 5) {
                    text.setText("You win！ ");
                    mStepProgressBar.setCurrentProgressDot(-1);
                    final Button button_reset = (Button) findViewById(R.id.reset);
                    button_reset.setText("Menu");
                    button_reset.setBackgroundResource(R.drawable.buttonshape2);
                }

            } else {
                correctPlayer = MediaPlayer.create(this, R.raw.wrong);
                correctPlayer.start();
                tmpString = "";

            }

        } else {
            mStepProgressBar.next();
        }


    }

    public void gamereset(View v) {
        tmpString = "";
        mStepProgressBar.setCurrentProgressDot(-1);
    }

    public void startlevel() throws InterruptedException {

        mStepProgressBar.setCurrentProgressDot(-1);

        if (player != null) {
            player.stop();
            player.reset();
            player.release();
            player = null;
        }


        switch (level) {
            //level 0
            case 0:

                player = MediaPlayer.create(this, R.raw.doo);
                player.start();
                winkbtn(bt1);
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                player = MediaPlayer.create(this, R.raw.re);
                player.start();
                winkbtn(bt2);
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                player = MediaPlayer.create(this, R.raw.mi);
                player.start();
                winkbtn(bt3);
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                player = MediaPlayer.create(this, R.raw.fa);
                player.start();
                winkbtn(bt4);
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                mStepProgressBar.setCurrentProgressDot(-1);
                break;

            //level 1
            case 1:
                player = MediaPlayer.create(this, R.raw.doo);
                player.start();
                winkbtn(bt1);
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                //
                player = MediaPlayer.create(this, R.raw.re);
                player.start();
                winkbtn(bt2);
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                //
                player = MediaPlayer.create(this, R.raw.mi);
                player.start();
                winkbtn(bt3);
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                //
                player = MediaPlayer.create(this, R.raw.re);
                player.start();
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                //
                player = MediaPlayer.create(this, R.raw.fa);
                player.start();
                winkbtn(bt4);
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                mStepProgressBar.setCurrentProgressDot(-1);
                break;

            //level 2
            case 2:

                //
                player = MediaPlayer.create(this, R.raw.re);
                player.start();
                winkbtn(bt2);
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                //
                player = MediaPlayer.create(this, R.raw.mi);
                player.start();
                winkbtn(bt3);
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                //
                player = MediaPlayer.create(this, R.raw.doo);
                player.start();
                winkbtn(bt1);
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                //
                player = MediaPlayer.create(this, R.raw.re);
                player.start();
                winkbtn(bt2);
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                //
                player = MediaPlayer.create(this, R.raw.fa);
                player.start();
                winkbtn(bt4);
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                //
                player = MediaPlayer.create(this, R.raw.mi);
                player.start();
                winkbtn(bt3);
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                mStepProgressBar.setCurrentProgressDot(-1);
                break;


            //level 3
            case 3:
                //
                player = MediaPlayer.create(this, R.raw.fa);
                player.start();
                winkbtn(bt4);
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                //
                player = MediaPlayer.create(this, R.raw.doo);
                player.start();
                winkbtn(bt1);
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                //
                player = MediaPlayer.create(this, R.raw.re);
                player.start();
                winkbtn(bt2);
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                //
                player = MediaPlayer.create(this, R.raw.mi);
                player.start();
                winkbtn(bt3);
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                //
                player = MediaPlayer.create(this, R.raw.mi);
                player.start();
                winkbtn(bt1);
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                //
                player = MediaPlayer.create(this, R.raw.fa);
                player.start();
                winkbtn(bt4);
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                //
                player = MediaPlayer.create(this, R.raw.re);
                player.start();
                winkbtn(bt2);
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                mStepProgressBar.setCurrentProgressDot(-1);
                break;
            //level 4
            // 42312324
            case 4:
                //
                player = MediaPlayer.create(this, R.raw.fa);
                player.start();
                winkbtn(bt4);
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                //
                player = MediaPlayer.create(this, R.raw.re);
                player.start();
                winkbtn(bt2);
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                //
                player = MediaPlayer.create(this, R.raw.mi);
                player.start();
                winkbtn(bt3);
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                //
                player = MediaPlayer.create(this, R.raw.doo);
                player.start();
                winkbtn(bt1);
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                //
                player = MediaPlayer.create(this, R.raw.re);
                player.start();
                winkbtn(bt2);
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                //
                player = MediaPlayer.create(this, R.raw.mi);
                player.start();
                winkbtn(bt3);
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                //
                player = MediaPlayer.create(this, R.raw.re);
                player.start();
                winkbtn(bt2);
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                //
                player = MediaPlayer.create(this, R.raw.fa);
                player.start();
                winkbtn(bt4);
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                mStepProgressBar.setCurrentProgressDot(-1);
                break;

        }
        //btn_sound.setEnabled(true);
    }

    public void winkbtn(Button btn) {
        animation = new AlphaAnimation(1, 0);
        animation.setDuration(400);
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatMode(Animation.REVERSE);
        btn.startAnimation(animation);
    }

    public void hint1(View view) {
        Button angryButton = (Button) findViewById(R.id.angry_btn);
        angryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("test","123");
                AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(GameDouble.this);
                myAlertBuilder.setTitle("音準練習");
                myAlertBuilder.setMessage("下面4個方格各代表一個音，點擊Sound會聽到簡單旋律，記下此旋律並按下方格重演一遍，按錯可點Reset重來，成功可進入下一等級。\n小技巧：旋律播放結束前切勿提早開始點方格！");
                myAlertBuilder.setPositiveButton("OK", new
                        DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                myAlertBuilder.show();
            }
        });
    }


}