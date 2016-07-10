package com.davidparkeredwards.toddlertimer;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.widget.RadioGroup;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Timer;

/**
 * Created by User on 7/7/2016.
 */

public class TimerRequest implements Parcelable {
    int timeLength;
    int sound;

    public int getTimeLength() {
        return timeLength;
    }

    public int getSound() {
        return sound;
    }

    public TimerRequest(int timeFromSetTimer,int soundFromSetTimer){
        timeLength = timeFromSetTimer;
        sound = soundFromSetTimer;
    }
    public TimerRequest(Parcel input){
        timeLength = input.readInt();
        sound = input.readInt();
    }

    public void setTimerRequest(int timeLength, int sound) {
        this.timeLength = timeLength;
        this.sound = sound;
    }
    public Object getTimerRequest() {
        return this;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(timeLength);
        dest.writeInt(sound);
    }
    public static final Parcelable.Creator<TimerRequest> CREATOR
            = new Parcelable.Creator<TimerRequest>() {
        public TimerRequest createFromParcel(Parcel in) {
            Log.i("Create from parcel", "TimerRequest");
            return new TimerRequest(in);
        }

        public TimerRequest[] newArray(int size) {
            return new TimerRequest[size];
        }
    };

}
