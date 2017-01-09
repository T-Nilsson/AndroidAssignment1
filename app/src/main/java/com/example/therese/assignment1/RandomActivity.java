package com.example.therese.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class RandomActivity extends AppCompatActivity implements View.OnClickListener
{
    TextView mRandomNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        Button buttonRandom = (Button) findViewById(R.id.btnRandom);
        buttonRandom.setOnClickListener(this);

       mRandomNumber= (TextView) findViewById(R.id.randomNumber);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnRandom:
                Random randomNumber = new Random();
                mRandomNumber.setText(String.valueOf(randomNumber.nextInt((100)+1)));
                break;


        }
    }
}
