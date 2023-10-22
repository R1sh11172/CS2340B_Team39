package com.example.cs2340b_team39.ViewModel;

import android.app.Activity;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cs2340b_team39.Model.Leaderboard;
import com.example.cs2340b_team39.Model.Model;
import com.example.cs2340b_team39.Model.Player;
import com.example.cs2340b_team39.Model.PlayerMovement;
import com.example.cs2340b_team39.Model.Score;
import com.example.cs2340b_team39.View.ActiveSub;
import com.example.cs2340b_team39.View.GameActivity;
import com.example.cs2340b_team39.View.SubPlayerPos;

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
}


