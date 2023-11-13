package com.example.cs2340b_team39.View;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cs2340b_team39.Model.CollisionSub;
import com.example.cs2340b_team39.Model.Difficulty;
import com.example.cs2340b_team39.Model.Enemy;
import com.example.cs2340b_team39.Model.EnemyMovement;
import com.example.cs2340b_team39.Model.Player;
import com.example.cs2340b_team39.R;
import com.example.cs2340b_team39.ViewModel.ViewModel;

public class GameActivityMap2 extends AppCompatActivity {
    private Player player = Player.getPlayer();
    //private boolean active;
    private static ImageView sprite, enemy1, enemy2;
    private static ImageView bottom, top;
    private static TextView health;

    private boolean finished;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamestatemap2);
        TextView name = findViewById(R.id.nameDisplay);
        health = findViewById(R.id.healthDisplay);
        TextView difficulty = findViewById(R.id.difficultyDisplay);
        TextView score = findViewById(R.id.scoreDisplay);
        name.setText("Name: " + player.getName());
        health.setText("Health: " + player.getHealth() + "");
        player.getScore().setTextView(score);
        finished = false;
        difficulty.setText("Difficulty: " + Difficulty.values()[(int) player.getDifficulty()] + "");
        //Button endButton = findViewById(R.id.button);
//        Button nextMap = findViewById(R.id.nextmap);
        enemy1 = findViewById(R.id.imageView41);
        enemy2 = findViewById(R.id.imageView47);
        enemy1.setX((float) 400);
        enemy1.setY((float) 800);
        double x1 = enemy1.getX();
        enemy2.setX((float) 700);
        enemy2.setY((float) 1000);

        Enemy e1 = ViewModel.initEnemy(enemy1, 1);
        Enemy e2 = ViewModel.initEnemy(enemy2, 3);
        e1.setMovement(new EnemyMovement(e1));
        e2.setMovement(new EnemyMovement(e2));
        sprite = findViewById(R.id.imageView);
        bottom = findViewById(R.id.imageView16);
        top = findViewById(R.id.imageView26);
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
        ActiveSub.setG2Active(true);
        ActiveSub.initializePlayer();
        if (e1 != null) {
            e1.movePattern();
        }

        if (e2 != null) {
            e2.movePattern();
        }
        new CountDownTimer(300000, 100) {
            public void onTick(long millisUntilFinished) {
                if (!finished) {
                    endGame();
                }
            }
            public  void onFinish() {
            }
        }.start();
//        nextMap.setOnClickListener(v -> {
//            Intent nextIntent = new Intent(GameActivityMap2.this, GameActivityMap3.class);
//            ActiveSub.setG2Active(false);
//            startActivity(nextIntent);
//        });
        //        endButton.setOnClickListener(v -> {
        //            Intent endIntent = new Intent(GameActivityMap2.this, EndActivity.class);
        //            startActivity(endIntent);
        //        });
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
        if (player.getPlayerX() > 900 && player.getPlayerX() < 1000 && player.getPlayerY() > 650 && player.getPlayerY() < 750) {
            Intent nextIntent = new Intent(GameActivityMap2.this, GameActivityMap3.class);
            ActiveSub.setG2Active(false);
            startActivity(nextIntent);
        }
        return true;
    }
    public static ImageView getSprite() {
        return sprite;
    }
    public static ImageView getTop() {
        return top;
    }
    public static ImageView getBottom() {
        return bottom;
    }
    public static void setHealth(double healthVal) {
        health.setText("Health: " + healthVal);
    }
    public void endGame() {
        if (player.getHealth() <= 0) {
            finished = true;
            CollisionSub.getCollision().clearCollisions();
            Intent endIntent = new Intent(GameActivityMap2.this, EndActivity.class);
            ActiveSub.setG2Active(false);
            startActivity(endIntent);
        }
    }
}