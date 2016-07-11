package com.davidparkeredwards.toddlertimer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.davidparkeredwards.toddlertimer.R;



import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.InputMismatchException;
import java.util.Timer;
import java.util.TimerTask;

public class NewClock extends AppCompatActivity {
   //Global variables
    TimerRequest controlTimer;
    int repititions = 0;
    Timer clock = new Timer();

    //All action runs onCreate, so onCreate method contains methods to run
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("OnCreate", "onCreate: Creating");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_clock);

        TimerRequest newTimer = getIntent().getParcelableExtra("newTimer");
        Log.i("OnCreate", "onCreate: "+ newTimer.timeLength);
        controlTimer = newTimer;

        clock.schedule(new runClock(),1000,1000);
    }


    class runClock extends TimerTask {
        public void run() {
            Log.e("runClock", "Repetitions are " + repititions);
            repititions += 1;
            changeText();
            if (repititions >= controlTimer.timeLength) {
                clock.cancel();
                Log.e("End", "Activity Ending");
            }
            }
        }
        public void changeText() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    TextView changeText = (TextView) findViewById(R.id.generalDisplay);
                    changeText.setText("Minutes left" + (controlTimer.timeLength - repititions));
                }
            });

    }

}

