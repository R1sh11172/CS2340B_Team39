package com.example.cs2340b_team39;

import java.util.Calendar;
import java.util.Date;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.TextView;

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
                    scoreCount.setText("Score: " + String.valueOf(score));
                    score--;
                }
            }
            public  void onFinish() {
                scoreCount.setText(0);
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
