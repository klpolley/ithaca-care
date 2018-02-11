package com.example.icwc.volunteerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class FirstQuestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_question);

        ImageButton btnA = (ImageButton) findViewById(R.id.op1A);
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent advance = new Intent(getApplicationContext(), SecondQuestion.class);
                advance.putExtra("response", "A");
                startActivity(advance);
            }
        });

        ImageButton btnB = (ImageButton) findViewById(R.id.op1B);
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent advance = new Intent(getApplicationContext(), SecondQuestion.class);
                advance.putExtra("response", "B");
                startActivity(advance);
            }
        });

        ImageButton btnC = (ImageButton) findViewById(R.id.op1C);
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent advance = new Intent(getApplicationContext(), SecondQuestion.class);
                advance.putExtra("response", "C");
                startActivity(advance);
            }
        });

        ImageButton btnD = (ImageButton) findViewById(R.id.op1D);
        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent advance = new Intent(getApplicationContext(), SecondQuestion.class);
                advance.putExtra("response", "D");
                startActivity(advance);
            }
        });
    }


}
