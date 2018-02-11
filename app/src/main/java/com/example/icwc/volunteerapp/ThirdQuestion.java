package com.example.icwc.volunteerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ThirdQuestion extends AppCompatActivity {

    String responseCarry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_question);

        if (getIntent().hasExtra("response")){
            responseCarry = getIntent().getExtras().getString("response");
        }

        ImageButton btnA = (ImageButton) findViewById(R.id.op3A);
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent advance = new Intent(getApplicationContext(), Results.class);
                advance.putExtra("response", responseCarry+"A");
                startActivity(advance);
            }
        });

        ImageButton btnB = (ImageButton) findViewById(R.id.op3B);
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent advance = new Intent(getApplicationContext(), Results.class);
                advance.putExtra("response", responseCarry+"B");
                startActivity(advance);
            }
        });

        ImageButton btnC = (ImageButton) findViewById(R.id.op3C);
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent advance = new Intent(getApplicationContext(), Results.class);
                advance.putExtra("response", responseCarry+"C");
                startActivity(advance);
            }
        });

        ImageButton btnD = (ImageButton) findViewById(R.id.op3D);
        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent advance = new Intent(getApplicationContext(), Results.class);
                advance.putExtra("response", responseCarry+"D");
                startActivity(advance);
            }
        });
    }
}
