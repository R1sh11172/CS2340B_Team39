package com.example.cs2340b_team39.View;

import static com.example.cs2340b_team39.ViewModel.ViewModel.endGame;

import android.content.Intent;
//import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
//import android.widget.EditText;
import android.view.View;
import android.widget.ImageView;
//import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cs2340b_team39.Model.CollisionSub;
import com.example.cs2340b_team39.Model.Difficulty;
import com.example.cs2340b_team39.Model.Enemy;
import com.example.cs2340b_team39.Model.EnemyMovement;
import com.example.cs2340b_team39.Model.Player;
import com.example.cs2340b_team39.Model.PowerUp;
import com.example.cs2340b_team39.Model.PowerUpSpeed;
import com.example.cs2340b_team39.Model.PowerUpDecorator;
import com.example.cs2340b_team39.R;
import com.example.cs2340b_team39.ViewModel.ViewModel;

public class GameActivity extends AppCompatActivity {
    private static Player player;
    private static ImageView sprite;
    private static ImageView enemy1;
    private static ImageView enemy2;
    private static ImageView leftC;
    private static ImageView rightC;
    private static ImageView top;
    private static ImageView bottom;
    private static int screenWidth;
    private static int screenHeight;
    private static TextView health;
    private static ImageView powerup;

    private static boolean finished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_state);
        screenWidth = getResources().getDisplayMetrics().widthPixels;
        screenHeight = getResources().getDisplayMetrics().heightPixels;
        TextView name = findViewById(R.id.nameDisplay);
        health = findViewById(R.id.healthDisplay);
        TextView difficulty = findViewById(R.id.difficultyDisplay);
        TextView score = findViewById(R.id.scoreDisplay);
        player = Player.getPlayer();
        finished = false;
        name.setText("Name: " + player.getName());
        health.setText("Health: " + player.getHealth() + "");
        player.getScore().count();
        ViewModel.changeScoreId(score);
        difficulty.setText("Difficulty: " + Difficulty.values()[(int) player.getDifficulty()] + "");
        enemy1 = findViewById(R.id.imageView9);
        enemy2 = findViewById(R.id.imageView44);
        powerup = findViewById(R.id.imageView43);
        enemy1.setX((float) screenWidth / 3);
        enemy1.setY((float) screenHeight / 2);
        double x1 = enemy1.getX();
        enemy2.setX((float) screenWidth / 2);
        enemy2.setY((float) screenHeight / 2);

        Enemy e1 = ViewModel.initEnemy(enemy1, 2);
        Enemy e2 = ViewModel.initEnemy(enemy2, 1);
        e1.setMovement(new EnemyMovement(e1));
        e2.setMovement(new EnemyMovement(e2));
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
        if (keyCode == KeyEvent.KEYCODE_X) {
            player.setIsAttacking(true);
            ImageView sword = findViewById(R.id.imageView49);
                sword.setVisibility(View.INVISIBLE);
                sword.setVisibility(View.VISIBLE);
        } else if (keyCode != KeyEvent.KEYCODE_X) {
            player.setIsAttacking(false);
        }

        //checkCollisions();
        if (player.getPlayerX() > 880 && player.getPlayerX() < 980 && player.getPlayerY() > 1000
                && player.getPlayerY() < 1100) {
            CollisionSub.getCollision().clearCollisions();
            Intent nextIntent = new Intent(GameActivity.this, GameActivityMap2.class);
            ActiveSub.setG1Active(false);
            startActivity(nextIntent);
        }
        if (player.getPlayerX() > powerup.getX()
                && player.getPlayerX() < powerup.getX() + powerup.getWidth()
                && player.getPlayerY() > powerup.getY()
                && player.getPlayerY() < powerup.getY() + powerup.getHeight()) {
            if (powerup.getVisibility() == View.VISIBLE) {
                PowerUp powerUp = new PowerUpSpeed(null);
                powerUp.applyPowerUp(player);
            }
            powerup.setVisibility(View.INVISIBLE);
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
    public static void setHealth(double healthVal) {
        health.setText("Health: " + healthVal);
    }

    public void endGame() {
        if (player.getHealth() <= 0) {
            finished = true;
            CollisionSub.getCollision().clearCollisions();
            Intent endIntent = new Intent(GameActivity.this, EndActivity.class);
            ActiveSub.setG1Active(false);
            startActivity(endIntent);
        }
    }
}