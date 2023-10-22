package com.example.cs2340b_team39.View;

import android.content.Intent;
//import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
//import android.widget.EditText;
import android.widget.ImageView;
//import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cs2340b_team39.Model.Difficulty;
import com.example.cs2340b_team39.Model.Player;
import com.example.cs2340b_team39.R;
import com.example.cs2340b_team39.ViewModel.ViewModel;

public class GameActivity extends AppCompatActivity {
    private static Player player;
    private static ImageView sprite;
    private static ImageView leftC, rightC, top, bottom;
    private static int screenWidth, screenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_state);
        screenWidth = getResources().getDisplayMetrics().widthPixels;
        screenHeight = getResources().getDisplayMetrics().heightPixels;
        TextView name = findViewById(R.id.nameDisplay);
        TextView health = findViewById(R.id.healthDisplay);
        TextView difficulty = findViewById(R.id.difficultyDisplay);
        TextView score = findViewById(R.id.scoreDisplay);
        player = Player.getPlayer();
        name.setText("Name: " + player.getName());
        health.setText("Health: " + player.getHealth() + "");
        player.getScore().count();
        ViewModel.changeScoreId(score);
        difficulty.setText("Difficulty: " + Difficulty.values()[(int) player.getDifficulty()] + "");
//        Button nextMap = findViewById(R.id.nextmap);
        //Button endButton = findViewById(R.id.button);
        sprite = findViewById(R.id.imageView);
        leftC = findViewById(R.id.imageView36);
        rightC = findViewById(R.id.imageView40);
        top = findViewById(R.id.imageView26);
        bottom = findViewById(R.id.imageView15);
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
        ActiveSub.setG1Active(true);
        ActiveSub.initializePlayer();
//        nextMap.setOnClickListener(v -> {
//            Intent nextIntent = new Intent(GameActivity.this, GameActivityMap2.class);
//            ActiveSub.setG1Active(false);
//            startActivity(nextIntent);
//        });
        //        endButton.setOnClickListener(v -> {
        //            Intent endIntent = new Intent(GameActivity.this, EndActivity.class);
        //            startActivity(endIntent);
        //        });
    }
    public static ImageView getSprite() {
        return sprite;
    }
    public static int getWidth() {
        return screenWidth;
    }
    public static int getHeight() {
        return screenHeight;
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // logic to move the player (remember to check collisions)
        if (keyCode == KeyEvent.KEYCODE_D) {
            ViewModel.updatePlayerPosition(1);
        } else if (keyCode == KeyEvent.KEYCODE_A) {
            ViewModel.updatePlayerPosition(3);
        } else if (keyCode == KeyEvent.KEYCODE_W) {
            ViewModel.updatePlayerPosition(0);
        } else if (keyCode == KeyEvent.KEYCODE_S) {
            ViewModel.updatePlayerPosition(2);
        }
        //checkCollisions();
        if (player.getPlayerX() > 880 && player.getPlayerX() < 980 && player.getPlayerY() > 1000 && player.getPlayerY() < 1100) {
            Intent nextIntent = new Intent(GameActivity.this, GameActivityMap2.class);
            ActiveSub.setG1Active(false);
            startActivity(nextIntent);
        }
        return true;
    }
    public static ImageView getLeftC() {
        return leftC;
    }
    public static ImageView getRightC() {
        return rightC;
    }
    public static ImageView getTop() {
        return top;
    }
    public static ImageView getBottom() {
        return bottom;
    }
}