package com.example.cs2340b_team39.Model;

import java.util.Calendar;
import java.util.Date;

import android.content.Intent;
import android.os.CountDownTimer;
import android.widget.TextView;

import com.example.cs2340b_team39.View.ActiveSub;
import com.example.cs2340b_team39.View.EndActivity;
import com.example.cs2340b_team39.View.GameActivity;
import com.example.cs2340b_team39.ViewModel.ViewModel;

public class Score implements Comparable {

    private String name;
    private Date date;
    private int score = 300;
    private TextView scoreCount;
    private Player player;
    private boolean finished = false;

    public Score() {
        date = Calendar.getInstance().getTime();
    }
    public int compareTo(Object o) {
        if (o == null) {
            return 1;
        }
        if (o.getClass() != Score.class) {
            return 1;
        }
        //Log.i("Test", "Made it");
        Score scoreO = (Score) o;
        if (this.score > scoreO.score) {
            return 1;
        } else if (this.score < scoreO.score) {
            return -1;
        }
        return 0;
    }
    public void count() {
        new CountDownTimer(300000, 1000) {
            public void onTick(long millisUntilFinished) {
                if (!finished) {
                    ViewModel.updateScore(scoreCount, score);
                    score--;
                }
            }
            public  void onFinish() {
                ViewModel.updateScore(scoreCount, score);
            }
        }.start();
    }

    public String toString() {
        return "Score: " + score + " Name: " + name + " Date: " + date;
    }

    public void setTextView(TextView t) {
        scoreCount = t;
    }
    public void setPlayer() {
        player = Player.getPlayer();
        name = player.getName();
    }
    public void setFinished(boolean t) {
        finished = t;
    }
    public void setScore(int val) {
        score = val;
    }


}
