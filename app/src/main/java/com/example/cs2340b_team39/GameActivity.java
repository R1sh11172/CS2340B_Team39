package com.example.cs2340b_team39;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
        endButton.setOnClickListener(v -> {
            Intent endIntent = new Intent(GameActivity.this, EndActivity.class);
            startActivity(endIntent);
        });
    }


    public static void createPlayer(String name, int characterId, double difficulty) {
        player = new Player(name, characterId, difficulty);
    }
}