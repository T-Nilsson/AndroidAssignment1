package com.example.therese.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BMIActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mWeight;
    EditText mLength;
    TextView mBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        Button buttonBmi = (Button)findViewById(R.id.buttonBMI);

        mWeight = (EditText)findViewById(R.id.weight);
        mLength = (EditText)findViewById(R.id.length);


            mBMI = (TextView) findViewById(R.id.showBMI);
            buttonBmi.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        if(mWeight.getText().toString().trim().length() == 0  || mLength.getText().toString().trim().length() == 0 ){
            Toast.makeText(this, "Fill in fields", Toast.LENGTH_LONG).show();
            return;}

       float weight= Float.parseFloat(mWeight.getText().toString());
        float height =Float.parseFloat(mLength.getText().toString());


        height= height/100;
        float sum = (weight/(height*height));
        switch(v.getId()){
            case R.id.buttonBMI:

                    mBMI.setText(String.valueOf(sum));


                break;
        }
}}
