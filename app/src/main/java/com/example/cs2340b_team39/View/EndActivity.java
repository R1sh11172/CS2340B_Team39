package com.example.cs2340b_team39.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cs2340b_team39.Model.Leaderboard;
import com.example.cs2340b_team39.Model.Player;
import com.example.cs2340b_team39.R;
import com.example.cs2340b_team39.ViewModel.ViewModel;

public class EndActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending);
        Leaderboard lb = Leaderboard.getLeaderboard();
        Player player = Player.getPlayer();
        player.getScore().setFinished(true);
        TextView top = findViewById(R.id.textView8);
        if (player.getHealth() > 0) {
            ViewModel.updateScores();
        } else {
            top.setText("You Lost!");
        }
        //lb.updateScores(player.getScore());
        Button resButton = findViewById(R.id.restart);
        TextView current = findViewById(R.id.current1);
        TextView score1 = findViewById(R.id.score1);
        TextView score2 = findViewById(R.id.score2);
        TextView score3 = findViewById(R.id.score3);
        TextView score4 = findViewById(R.id.score4);
        TextView score5 = findViewById(R.id.score5);
        current.setText(current.getText() + Player.getPlayer().getScore().toString());
        if (lb.getScores()[0] != null) {
            score1.setText(score1.getText() + lb.getScores()[0].toString());
        }
        if (lb.getScores()[1] != null) {
            score2.setText(score2.getText() + lb.getScores()[1].toString());
        }
        if (lb.getScores()[2] != null) {
            score3.setText(score3.getText() + lb.getScores()[2].toString());
        }
        if (lb.getScores()[3] != null) {
            score4.setText(score4.getText() + lb.getScores()[3].toString());
        }
        if (lb.getScores()[4] != null) {
            score5.setText(score5.getText() + lb.getScores()[4].toString());
        }
        resButton.setOnClickListener(v -> {
            Intent endIntent = new Intent(EndActivity.this, MainActivity.class);
            player.resetPlayer();
            startActivity(endIntent);
        });
    }
}
