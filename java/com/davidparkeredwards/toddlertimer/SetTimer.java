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
    TextView minutes;
    RadioGroup sounds;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_timer);

        minutes = (TextView) findViewById(R.id.minutes);
        sounds = (RadioGroup) findViewById(R.id.sounds);
    }

    public void incrementMinutes(View view) {

        int minuteInt = Integer.parseInt(minutes.getText().toString());
        minuteInt += 1;
        minutes.setText(Integer.toString(minuteInt));
    }

    public void decrementMinutes(View view) {
        int minuteInt = Integer.parseInt(minutes.getText().toString());
        if (minuteInt > 0) {
            minuteInt -= 1;
            minutes.setText(Integer.toString(minuteInt));
        }
    }

    public Parcelable createNewTimer() {

        //Assign minutes to new Timer

        String minuteLengthString = minutes.getText().toString();
        int minuteLength = Integer.parseInt(minuteLengthString);
        Log.i("CreateNewTimer", "createNewTimer: minutes" + minuteLength);

        //Assign sound to new Timer

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
