package com.davidparkeredwards.toddlertimer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import layout.Practice;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setTimer(View view) {
        Intent launchSetTimer = new Intent(this, SetTimer.class);

        startActivity(launchSetTimer);
    }
}
