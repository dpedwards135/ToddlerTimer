package com.davidparkeredwards.toddlertimer;

import android.widget.RadioGroup;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by User on 7/7/2016.
 */

public class TimerRequest {
    int timeLength;
    int sound;
    public TimerRequest(int timeFromSetTimer,int soundFromSetTimer){
        timeLength = timeFromSetTimer;
        sound = soundFromSetTimer;
    }
}
