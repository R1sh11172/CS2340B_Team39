package com.example.cs2340b_team39;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class GameActivity extends AppCompatActivity {
    private static Player player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_state);
        TextView name = findViewById(R.id.nameDisplay);
        TextView health = findViewById(R.id.healthDisplay);
        TextView difficulty = findViewById(R.id.difficultyDisplay);
        name.setText(player.getName());
        health.setText(player.getHealth() + "");
        difficulty.setText(player.getDifficulty() + "");
    }


    public static void createPlayer(String name, int characterId, double difficulty) {
        player = new Player(name, characterId, difficulty);
    }
}