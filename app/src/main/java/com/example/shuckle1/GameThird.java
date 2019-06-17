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

package com.example.shuckle1;////////////////////////////////////////////////////////////////////////////////
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

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.marcok.stepprogressbar.StepProgressBar;


public class GameThird extends Activity implements View.OnTouchListener
{
    private TextView text;
    private Button btn_sound;
    public Button btn_bee;
    public Button btn_star;
    public Button btn_sheep;
    public MediaPlayer player;
    public MediaPlayer correctPlayer;
    public StepProgressBar mStepProgressBar;
    public TextView infoTextView;
    public String mTopic;
    public Boolean mStart;


    String[] answer = {
            "533422123455553342213551",
            "1155665443322155443325544332",
            "3212333222333321233322321"};

    int count = 0;
    String tmpString ="";

    // On create
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_game);

        // Create midi driver
        infoTextView = findViewById(R.id.info);
        btn_sound =  findViewById(R.id.soundout);
        btn_bee =  findViewById(R.id.bee);
        btn_star =  findViewById(R.id.star);
        btn_sheep =  findViewById(R.id.sheep);

        mStepProgressBar = (StepProgressBar)findViewById(R.id.stepProgressBar);
        mTopic="bee";
        mStart = false;
        View v = findViewById(R.id.soundout);
        btn_sound.setOnTouchListener(this);

        infoTextView.setTextAppearance(getApplicationContext(),
                R.style.AudioFileInfoOverlayText);

    }

    // On resume
    @Override
    protected void onResume()
    {
        super.onResume();
        // Start midi
    }

    // On pause
    @Override
    protected void onPause()
    {
        super.onPause();
        // Stop player
        if (player != null)
            player.stop();
    }


    // On touch

    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        int action = event.getAction();

        switch(action) {
            case MotionEvent.ACTION_DOWN:
                btn_sound.setEnabled(false);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            switch(mTopic) {
                                case "bee":
                                    Beesound();
                                    break;
                                case "star":
                                    Starsound();
                                    break;
                                case "sheep":
                                    Sheepsound();
                                    break;}
                            Thread.sleep(100);
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


    public void soundOne(View v)
    {

        int id = v.getId();

        if (player != null)
        {
            player.stop();
            player.reset();
            player.release();
            player = null;
        }

        switch (id) {
            case R.id.Do:
                player = MediaPlayer.create(this, R.raw.doo);
                player.start();
                tmpString+="1";
                break;
            case R.id.Re:
                player = MediaPlayer.create(this, R.raw.re);
                player.start();
                tmpString+="2";
                break;
            case R.id.Mi:
                player = MediaPlayer.create(this, R.raw.mi);
                player.start();
                tmpString+="3";
                break;
            case R.id.Fa:
                player = MediaPlayer.create(this, R.raw.fa);
                player.start();
                tmpString+="4";
                break;
            case R.id.Sol:
                player = MediaPlayer.create(this, R.raw.sol);
                player.start();
                tmpString+="5";
                break;
            case R.id.La:
                player = MediaPlayer.create(this, R.raw.la);
                player.start();
                tmpString+="6";
                break;
            case R.id.Si:
                player = MediaPlayer.create(this, R.raw.ti);
                player.start();
                tmpString+="7";
                break;
        }


        String Panswer="";


        if(mTopic.equals("bee")){
            Panswer=answer[0];
        }
        else if (mTopic.equals("star")){
            Panswer =answer[1];
        }
        else if(mTopic.equals("sheep")){
            Panswer =answer[2];
        }

        count++;
        System.out.println(Panswer.substring(0,count));
        System.out.println(tmpString);

        if(mStart){
            if (Panswer.substring(0,count).equals(tmpString)){
                if(Panswer.length()==tmpString.length())
                {
                    correctPlayer = MediaPlayer.create(this, R.raw.correct);
                    correctPlayer.start();
                    tmpString = "";
                    mStart = false;
                    count=0;

                }

            }
            else {
                correctPlayer = MediaPlayer.create(this, R.raw.wrong);
                correctPlayer.start();
                tmpString = "";
                mStart = false;
                count=0;

            }

        }

    }



    public void gamereset(View v) {
        mStart = true;
        tmpString = "";
        count = 0;
    }


    public void Beesound()
    {
        soundplay(R.raw.sol,800);
        soundplay(R.raw.mi,800);
        soundplay(R.raw.mi,1600);
        //
        soundplay(R.raw.fa,800);
        soundplay(R.raw.re,800);
        soundplay(R.raw.re,1600);
        //
        soundplay(R.raw.doo,800);
        soundplay(R.raw.re,800);
        soundplay(R.raw.mi,800);
        soundplay(R.raw.fa,800);
        //
        soundplay(R.raw.sol,800);
        soundplay(R.raw.sol,800);
        soundplay(R.raw.sol,1600);
        //
        soundplay(R.raw.sol,800);
        soundplay(R.raw.mi,800);
        soundplay(R.raw.mi,1600);
        //
        soundplay(R.raw.fa,800);
        soundplay(R.raw.re,800);
        soundplay(R.raw.re,1600);
        //
        soundplay(R.raw.doo,800);
        soundplay(R.raw.mi,800);
        soundplay(R.raw.sol,800);
        soundplay(R.raw.sol,800);
        //
        soundplay(R.raw.doo,3200);
        player = MediaPlayer.create(this, R.raw.re);
        player.start();
        player.stop();
    }

    public void Starsound()
    {
        //1155665443322155443325544332
        soundplay(R.raw.doo,800);
        soundplay(R.raw.doo,800);
        soundplay(R.raw.sol,800);
        soundplay(R.raw.sol,800);
        soundplay(R.raw.la,800);
        soundplay(R.raw.la,800);
        soundplay(R.raw.sol,1600);
        soundplay(R.raw.fa,800);
        soundplay(R.raw.fa,800);
        soundplay(R.raw.mi,800);
        soundplay(R.raw.mi,800);
        soundplay(R.raw.re,800);
        soundplay(R.raw.re,800);
        soundplay(R.raw.doo,1600);
        //
        soundplay(R.raw.sol,800);
        soundplay(R.raw.sol,800);
        soundplay(R.raw.fa,800);
        soundplay(R.raw.fa,800);
        soundplay(R.raw.mi,800);
        soundplay(R.raw.mi,800);
        soundplay(R.raw.re,1600);
        //
        soundplay(R.raw.sol,800);
        soundplay(R.raw.sol,800);
        soundplay(R.raw.fa,800);
        soundplay(R.raw.fa,800);
        soundplay(R.raw.mi,800);
        soundplay(R.raw.mi,800);
        soundplay(R.raw.re,1600);
        player = MediaPlayer.create(this, R.raw.re);
        player.start();
        player.stop();

    }

    public void Sheepsound()
    {
        //3212333222333321233322321
        soundplay(R.raw.mi,800);
        soundplay(R.raw.re,800);
        soundplay(R.raw.doo,800);
        soundplay(R.raw.re,800);
        //
        soundplay(R.raw.mi,800);
        soundplay(R.raw.mi,800);
        soundplay(R.raw.mi,1600);
        //
        soundplay(R.raw.re,800);
        soundplay(R.raw.re,800);
        soundplay(R.raw.re,1600);
        //
        soundplay(R.raw.mi,800);
        soundplay(R.raw.mi,800);
        soundplay(R.raw.mi,1600);
        //2
        soundplay(R.raw.mi,800);
        soundplay(R.raw.re,800);
        soundplay(R.raw.doo,800);
        soundplay(R.raw.re,800);
        //
        soundplay(R.raw.mi,800);
        soundplay(R.raw.mi,800);
        soundplay(R.raw.mi,1600);
        // 3
        soundplay(R.raw.re,800);
        soundplay(R.raw.re,800);
        soundplay(R.raw.mi,800);
        soundplay(R.raw.re,800);
        //
        soundplay(R.raw.doo,3200);
        player = MediaPlayer.create(this, R.raw.re);
        player.start();
        player.stop();
    }


    public void mBee(View view)
    {
        mTopic="bee";
        btn_bee.setBackgroundResource(R.drawable.bee2);
        btn_star.setBackgroundResource(R.drawable.ic_star_border_black_24dp);
        btn_sheep.setBackgroundResource(R.drawable.sheep1);
    }

    public void mStar(View view)
    {
        mTopic="star";
        btn_bee.setBackgroundResource(R.drawable.bee1);
        btn_star.setBackgroundResource(R.drawable.ic_star_border_yellow);
        btn_sheep.setBackgroundResource(R.drawable.sheep1);
    }

    public void mSheep(View view)
    {
        mTopic="sheep";
        btn_bee.setBackgroundResource(R.drawable.bee1);
        btn_star.setBackgroundResource(R.drawable.ic_star_border_black_24dp);
        btn_sheep.setBackgroundResource(R.drawable.sheep2);
    }



    public void soundplay(int uri,int time)
    {
        //
        player = MediaPlayer.create(this, uri);
        player.start();
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        player.stop();
        player.release();
    }

}
