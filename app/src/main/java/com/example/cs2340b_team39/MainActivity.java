package com.example.cs2340b_team39;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button startBtn = findViewById(R.id.startbutton);
    private Button endBtn = findViewById(R.id.quitButton);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
        startBtn.setOnClickListener(v -> {
            //System.out.println("Button works");
            openConfigScreen();
        });

        endBtn.setOnClickListener(v -> {
            System.exit(0);
        });
    }

    public void openConfigScreen() {
        Intent intent = new Intent(this, ConfigActivity.class);
        startActivity(intent);
    }
}
