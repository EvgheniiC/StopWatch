package com.example.stopwatch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textViewUhr;
    Button buttonPausa;
    Button buttonStart;
    Button buttonReset;
    private  int seconds;
    private boolean isRunning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewUhr = findViewById(R.id.textViewUhr);
        buttonStart = findViewById(R.id.buttonStart);
        buttonPausa = findViewById(R.id.buttonPausa);
        buttonReset = findViewById(R.id.buttonReset);
        if (savedInstanceState !=null){
            seconds = savedInstanceState.getInt("seconds");
            isRunning = savedInstanceState.getBoolean("isRunning");
        }


        runTimer();
        View.OnClickListener oclBtn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.buttonPausa:
                     clockStop();
                     break;
                    case  R.id.buttonReset:
                     clockReset();
                     break;
                    case  R.id.buttonStart:
                       clockStart();
                     break;

                }
            }
        };
        buttonReset.setOnClickListener(oclBtn);
        buttonStart.setOnClickListener(oclBtn);
        buttonPausa.setOnClickListener(oclBtn);
    }

    @Override
    protected void onSaveInstanceState(Bundle outstate) {
        super.onSaveInstanceState(outstate);
        outstate.putInt("seconds",seconds);
        outstate.putBoolean("isRunning",isRunning);
    }

    public void clockReset(){

        isRunning = false;
        seconds = 0;

    }
    public void clockStop(){
        isRunning = false;
    }
    public void clockStart(){

        isRunning = true;

    }
    public void runTimer(){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

                int hour = seconds/3600;
                int minuten = (seconds%360)/60;
                int sec = seconds%60;

                String time = String.format("%d:%02d:%02d",hour,minuten,sec);
                textViewUhr.setText(time);
                if (isRunning){
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });


    }


}
