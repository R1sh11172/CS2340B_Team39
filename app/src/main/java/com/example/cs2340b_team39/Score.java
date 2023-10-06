package com.example.cs2340b_team39;

import java.sql.Time;
import java.util.Date;
import android.os.CountDownTimer;
import android.widget.TextView;

public class Score {

    private String name;
    private Time time;
    private int maxTime = 300;
    private Date date;
    private int score;
    private TextView scoreCount;

    public Score() {
        //name = Player.getPlayer().getName();
    }
    public void count() {
        new CountDownTimer(300000, 1000) {
            public void onTick(long millisUntilFinished) {
                scoreCount.setText(String.valueOf(maxTime));
                maxTime--;
            }
            public  void onFinish() {
                scoreCount.setText(0);
            }
        }.start();
    }

    public void setTextView(TextView t) {
        scoreCount = t;
    }
}
