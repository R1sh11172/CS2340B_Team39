package com.example.cs2340b_team39;

import org.junit.Test;

import static org.junit.Assert.*;
public class S2UnitTests {
    @Test
    public void addToEmptyLeaderboard() {
        Leaderboard lb = Leaderboard.getLeaderboard();
        Score s1 = new Score();
        s1.setScore(250);
        lb.updateScores(s1);
        Score[] expected = {s1, null, null, null, null};
        assertArrayEquals(lb.getScores(), expected);
    }
    @Test
    public void addHighScoreToFullLeaderboard() {
        Leaderboard lb = Leaderboard.getLeaderboard();
        Score s1 = new Score();
        s1.setScore(295);
        lb.updateScores(s1);
        Score s2 = new Score();
        s2.setScore(290);
        lb.updateScores(s2);
        Score s3 = new Score();
        s3.setScore(285);
        lb.updateScores(s3);
        Score s4 = new Score();
        s4.setScore(280);
        lb.updateScores(s4);
        Score s5 = new Score();
        s5.setScore(275);
        lb.updateScores(s5);
        Score s6 = new Score();
        s6.setScore(300);
        lb.updateScores(s6);
        Score[] expected = {s6,s1,s2,s3,s4};
        assertArrayEquals(lb.getScores(), expected);
    }
}