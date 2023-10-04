package com.example.cs2340b_team39;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivityMap3 extends AppCompatActivity {
    public static Player player = GameActivity.player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamestatemap2);
        TextView name = findViewById(R.id.nameDisplay);
        TextView health = findViewById(R.id.healthDisplay);
        TextView difficulty = findViewById(R.id.difficultyDisplay);
        TextView score = findViewById(R.id.scoreDisplay);
        name.setText(player.getName());
        health.setText(player.getHealth() + "");
        difficulty.setText(Difficulty.values()[(int) player.getDifficulty()] + "");
        Button endButton = findViewById(R.id.button);
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
            Intent nextIntent = new Intent(GameActivityMap3.this, GameActivity.class);
            startActivity(nextIntent);
        });
        endButton.setOnClickListener(v -> {
            Intent endIntent = new Intent(GameActivityMap3.this, EndActivity.class);
            startActivity(endIntent);
        });
    }
}
