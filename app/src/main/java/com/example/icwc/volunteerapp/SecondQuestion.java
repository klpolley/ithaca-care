package com.example.icwc.volunteerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SecondQuestion extends AppCompatActivity {

    String responseCarry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_question);

        if (getIntent().hasExtra("response")){
            responseCarry = getIntent().getExtras().getString("response");
        }

        ImageButton btnA = (ImageButton) findViewById(R.id.op2A);
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent advance = new Intent(getApplicationContext(), ThirdQuestion.class);
                advance.putExtra("response", responseCarry+"A");
                startActivity(advance);
            }
        });

        ImageButton btnB = (ImageButton) findViewById(R.id.op2B);
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent advance = new Intent(getApplicationContext(), ThirdQuestion.class);
                advance.putExtra("response", responseCarry+"B");
                startActivity(advance);
            }
        });

        ImageButton btnC = (ImageButton) findViewById(R.id.op2C);
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent advance = new Intent(getApplicationContext(), ThirdQuestion.class);
                advance.putExtra("response", responseCarry+"C");
                startActivity(advance);
            }
        });

        ImageButton btnD = (ImageButton) findViewById(R.id.op2D);
        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent advance = new Intent(getApplicationContext(), ThirdQuestion.class);
                advance.putExtra("response", responseCarry+"D");
                startActivity(advance);
            }
        });
    }
}
