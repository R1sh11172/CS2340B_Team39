package com.example.cs2340b_team39;

import android.content.Intent;
//import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
//import android.widget.EditText;
import android.widget.ImageView;
//import android.widget.RadioGroup;
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
        TextView score = findViewById(R.id.scoreDisplay);
        name.setText(player.getName());
        health.setText(player.getHealth() + "");
        player.getScore().count();
        player.getScore().setTextView(score);
        difficulty.setText(Difficulty.values()[(int) player.getDifficulty()] + "");
        Button nextMap = findViewById(R.id.nextmap);
        Button endButton = findViewById(R.id.button);
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
            Intent nextIntent = new Intent(GameActivity.this, GameActivityMap2.class);
            startActivity(nextIntent);
        });
        endButton.setOnClickListener(v -> {
            Intent endIntent = new Intent(GameActivity.this, EndActivity.class);
            startActivity(endIntent);
        });
    }


    public static void createPlayer(String name, int characterId, double difficulty) {
        player = Player.getPlayer(name, characterId, difficulty);
    }
}