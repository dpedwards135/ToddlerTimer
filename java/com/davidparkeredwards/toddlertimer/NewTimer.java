package com.davidparkeredwards.toddlertimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class NewTimer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
       /* timerX.schedule(countdown,10000);    */

    }
/*
    Timer timerX = new Timer();
    TimerTask countdown = new TimerTask() {
        @Override
        public void run() {
            TextView test = (TextView) findViewById(R.id.timer_test);
            test.setText("newthing");
        }
    };

*/
}



