package com.example.cs2340b_team39.ViewModel;

import android.widget.TextView;

import com.example.cs2340b_team39.Model.Leaderboard;
import com.example.cs2340b_team39.Model.Model;
import com.example.cs2340b_team39.Model.Player;
import com.example.cs2340b_team39.Model.Score;

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
}


