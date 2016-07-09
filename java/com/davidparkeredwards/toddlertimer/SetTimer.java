package com.davidparkeredwards.toddlertimer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SetTimer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_timer);
    }

    public void submitNewTimer(View view) {



        TextView minutes = (TextView) findViewById(R.id.minutes);
        String minuteLengthString = minutes.getText().toString();
        int minuteLength = Integer.parseInt(minuteLengthString);

        RadioGroup sounds = (RadioGroup) findViewById(R.id.sounds);
        int newSound = sounds.getCheckedRadioButtonId();

        TimerRequest newTimer = new TimerRequest(minuteLength, newSound);
        Log.i("New Timer Submitted", "submitNewTimer: " + newTimer);

        Intent launchTimer = new Intent(this, NewTimer.class);
        startActivity(launchTimer);
    }

}
