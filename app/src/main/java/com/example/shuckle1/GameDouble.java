
package com.example.shuckle1;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.marcok.stepprogressbar.StepProgressBar;

public class GameDouble extends Activity
        implements View.OnTouchListener, View.OnClickListener {

    private TextView text;
    private Button btn_sound;
    public MediaPlayer player;
    public MediaPlayer correctPlayer;
    public StepProgressBar mStepProgressBar;

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
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                player = MediaPlayer.create(this, R.raw.re);
                player.start();
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                player = MediaPlayer.create(this, R.raw.mi);
                player.start();
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                player = MediaPlayer.create(this, R.raw.fa);
                player.start();
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                mStepProgressBar.setCurrentProgressDot(-1);
                break;

            //level 1
            case 1:
                player = MediaPlayer.create(this, R.raw.doo);
                player.start();
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
                player = MediaPlayer.create(this, R.raw.mi);
                player.start();
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
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                //
                player = MediaPlayer.create(this, R.raw.mi);
                player.start();
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                //
                player = MediaPlayer.create(this, R.raw.doo);
                player.start();
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
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                //
                player = MediaPlayer.create(this, R.raw.mi);
                player.start();
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
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                //
                player = MediaPlayer.create(this, R.raw.doo);
                player.start();
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
                player = MediaPlayer.create(this, R.raw.mi);
                player.start();
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                //
                player = MediaPlayer.create(this, R.raw.mi);
                player.start();
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                //
                player = MediaPlayer.create(this, R.raw.fa);
                player.start();
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
                mStepProgressBar.setCurrentProgressDot(-1);
                break;
            //level 4
            // 42312324
            case 4:
                //
                player = MediaPlayer.create(this, R.raw.fa);
                player.start();
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
                player = MediaPlayer.create(this, R.raw.mi);
                player.start();
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                player.release();
                //
                player = MediaPlayer.create(this, R.raw.doo);
                player.start();
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
                player = MediaPlayer.create(this, R.raw.mi);
                player.start();
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
                mStepProgressBar.next();
                Thread.sleep(1000);
                player.stop();
                mStepProgressBar.setCurrentProgressDot(-1);
                break;

        }
        //btn_sound.setEnabled(true);
    }


}
