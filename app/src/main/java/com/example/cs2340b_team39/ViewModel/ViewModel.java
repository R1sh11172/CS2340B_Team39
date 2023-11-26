package com.example.cs2340b_team39.ViewModel;

import android.widget.ImageView;
import android.widget.TextView;


import com.example.cs2340b_team39.Model.CollisionSub;
import com.example.cs2340b_team39.Model.Enemy;
import com.example.cs2340b_team39.Model.Enemy1;
import com.example.cs2340b_team39.Model.Enemy2;
import com.example.cs2340b_team39.Model.Enemy3;
import com.example.cs2340b_team39.Model.Enemy4;
import com.example.cs2340b_team39.Model.Leaderboard;
import com.example.cs2340b_team39.Model.Model;
import com.example.cs2340b_team39.Model.Player;
import com.example.cs2340b_team39.Model.Score;
import com.example.cs2340b_team39.View.ActiveSub;
import com.example.cs2340b_team39.View.GameActivity;
import com.example.cs2340b_team39.View.GameActivityMap2;
import com.example.cs2340b_team39.View.GameActivityMap3;

public class ViewModel {
    public static boolean validateCredentials(String name, int difficulty, int character) {
        return Model.validateCredentials(name, difficulty, character);
    }

    public static void createPlayer(String name, int characterId, double difficulty) {
        Player player = Player.getPlayer(name, characterId, difficulty);
        player.getScore().setPlayer();
    }

    public static void updateScore(TextView scoreCount, int score) {
        scoreCount.setText("Score: " + String.valueOf(score));
    }

    public static void updateScores() {
        Leaderboard.getLeaderboard().updateScores(Player.getPlayer().getScore());
    }

    public static void changeScoreId(TextView scoreCount) {
        Score score = Player.getPlayer().getScore();
        score.setTextView(scoreCount);
    }

    public static void updatePlayerPosition(int dir) {
        Player.getPlayer().moveDir(dir);
        ActiveSub.updatePlayerPos();
    }

    public static int checkMap() {
        if (ActiveSub.getG1Active()) {
            return 1;
        } else if (ActiveSub.getG2Active()) {
            return 2;
        } else if (ActiveSub.getG3Active()) {
            return 3;
        }
        return 0;
    }

    public static void updateHealth() {
        int map = checkMap();
        if (map == 1) {
            GameActivity.setHealth(Player.getPlayer().getHealth());
        } else if (map == 2) {
            GameActivityMap2.setHealth(Player.getPlayer().getHealth());
        } else if (map == 3) {
            GameActivityMap3.setHealth(Player.getPlayer().getHealth());
        }
    }

    public static Enemy initEnemy(ImageView i, int type) {
        Enemy e;
        if (type == 1) {
            e = new Enemy1(i);
        } else if (type == 2) {
            e = new Enemy2(i);
        } else if (type == 3) {
            e = new Enemy3(i);
        } else if (type == 4) {
            e = new Enemy4(i);
        } else {
            return null;
        }
//        float scale = (float) e.getSize() / 20;
//        i.setScaleX(scale);
//        i.setScaleY(scale);

        CollisionSub.getCollision().addEnemy(e);
        return e;
    }

    public static void endGame() {
////        double health = Player.getPlayer().getHealth();
////        int map = checkMap();
////        if (health > 0) {
////            return;
////        }
////        if (map == 1) {
////            GameActivity.terminateGame();
////            ActiveSub.setG1Active(false);
////        } else if (map == 2) {
////            ActiveSub.setG2Active(false);
////        } else if (map == 3) {
////            Intent endIntent = new Intent(GameActivity.this, EndActivity.class);
////            ActiveSub.setG1Active(false);
////            startActivity(endIntent);
//        }
    }
    public static void updateEnemyPosition(Enemy e) {
        if (e.getSprite() == null) {
            return;
        }
        e.getSprite().setX((float) e.getX());
        e.getSprite().setY((float) e.getY());
    }
}

