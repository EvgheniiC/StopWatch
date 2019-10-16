package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textViewUhr;
    Button buttonPausa;
    Button buttonStart;
    Button buttonReset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewUhr = findViewById(R.id.textViewUhr);
        buttonStart = findViewById(R.id.buttonStart);
        buttonPausa = findViewById(R.id.buttonPausa);
        buttonReset = findViewById(R.id.buttonReset);

        View.OnClickListener oclBtn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.buttonPausa:
                     ;
                    case  R.id.buttonReset:
                        ;
                    case  R.id.buttonStart:
                        ;

                }


            }

        };
        buttonReset.setOnClickListener(oclBtn);
        buttonStart.setOnClickListener(oclBtn);
        buttonPausa.setOnClickListener(oclBtn);
    }

    public String clockUhr(String value){


    }



}
