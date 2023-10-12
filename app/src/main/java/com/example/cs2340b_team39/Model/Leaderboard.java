package com.example.cs2340b_team39.Model;

public class Leaderboard {
    private static volatile Leaderboard leaderboard;
    private Score[] scores;
    private Leaderboard() {
        scores = new Score[5];
    }
    public static Leaderboard getLeaderboard() {
        if (leaderboard == null) {
            synchronized (Leaderboard.class) {
                if (leaderboard == null) {
                    leaderboard = new Leaderboard();
                }
            }
        }
        return leaderboard;
    }
    public Score[] getScores() {
        return scores;
    }
    public void updateScores(Score current) {
        if (current == null) {
            return;
        }
        int insert = 0;
        for (int i = 0; i < 5; i++) {
            if (current.compareTo(scores[i]) > 0) {
                break;
            }
            insert++;
        }
        for (int i = 4; i > insert; i--) {
            scores[i] = scores[i - 1];
        }
        if (insert < 5 && insert > -1) {
            scores[insert] = current;
        }
    }
}
