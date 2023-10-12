package com.example.cs2340b_team39.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cs2340b_team39.Model.Difficulty;
import com.example.cs2340b_team39.Model.Player;
import com.example.cs2340b_team39.R;

public class GameActivityMap2 extends AppCompatActivity {
    private Player player = Player.getPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamestatemap2);
        TextView name = findViewById(R.id.nameDisplay);
        TextView health = findViewById(R.id.healthDisplay);
        TextView difficulty = findViewById(R.id.difficultyDisplay);
        TextView score = findViewById(R.id.scoreDisplay);
        name.setText("Name: " + player.getName());
        health.setText("Health: " + player.getHealth() + "");
        player.getScore().setTextView(score);
        difficulty.setText("Difficulty: " + Difficulty.values()[(int) player.getDifficulty()] + "");
        //Button endButton = findViewById(R.id.button);
        Button nextMap = findViewById(R.id.nextmap);
        ImageView sprite = findViewById(R.id.imageView);
        int spriteChoice = ConfigActivity.getSprite();
        switch (spriteChoice) {
            case 0:
                sprite.setImageResource(R.drawable.npc_elf);
                break;
            case 1:
                sprite.setImageResource(R.drawable.npc_knight_blue);
                break;
            case 2:
                sprite.setImageResource(R.drawable.npc_wizzard);
                break;
            default:
                break;
        }
        nextMap.setOnClickListener(v -> {
            Intent nextIntent = new Intent(GameActivityMap2.this, GameActivityMap3.class);
            startActivity(nextIntent);
        });
//        endButton.setOnClickListener(v -> {
//            Intent endIntent = new Intent(GameActivityMap2.this, EndActivity.class);
//            startActivity(endIntent);
//        });
    }

}