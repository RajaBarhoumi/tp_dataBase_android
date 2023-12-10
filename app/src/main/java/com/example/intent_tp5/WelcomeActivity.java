package com.example.intent_tp5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    TextView welcomeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        welcomeTV = findViewById(R.id.welcomeTV);

        String welcomeMessage = getIntent().getStringExtra("welcomeMessage");

        welcomeTV.setText(welcomeMessage);
    }
}