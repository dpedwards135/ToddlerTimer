package com.davidparkeredwards.toddlertimer;

import android.content.Intent;
import android.os.Parcelable;
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

    public Parcelable createNewTimer() {

        //Assign minutes to new Timer
        TextView minutes = (TextView) findViewById(R.id.minutes);
        String minuteLengthString = minutes.getText().toString();
        int minuteLength = Integer.parseInt(minuteLengthString);
        Log.i("CreateNewTimer", "createNewTimer: minutes" + minuteLength);

        //Assign sound to new Timer
        RadioGroup sounds = (RadioGroup) findViewById(R.id.sounds);
        int newSound = sounds.getCheckedRadioButtonId();
        Log.i("CreateNewTimer", "createNewTimer: soundId" + newSound);

        //Construct new Timer
        TimerRequest newTimer = new TimerRequest(minuteLength,newSound);

        return newTimer;
    }

    public void launchNewTimer (Parcelable newTimer) {
        Log.e("Submit Button", "launchNewTimer: Attempting to launch new timer");
        Intent launchNewClock = new Intent(this, NewClock.class);
        launchNewClock.putExtra("newTimer",newTimer);
        startActivity(launchNewClock);
    }

    public void submitNewTimer(View view) {
        launchNewTimer(createNewTimer());
    }
}
