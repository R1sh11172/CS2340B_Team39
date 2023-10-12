package com.example.cs2340b_team39.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
//import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cs2340b_team39.R;
//import com.example.cs2340b_team39.View.ConfigActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
        Button startBtn = findViewById(R.id.startbutton);
        Button endBtn = findViewById(R.id.quitButton);
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
