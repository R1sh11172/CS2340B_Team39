package com.example.cs2340b_team39;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
        Button startBtn = findViewById(R.id.startbutton);
        Button endBtn = findViewById(R.id.quitButton);

        startBtn.setOnClickListener(v -> {
            System.out.println("Button works");
        });

        endBtn.setOnClickListener(v -> {
            System.exit(0);
        });
    }
}
