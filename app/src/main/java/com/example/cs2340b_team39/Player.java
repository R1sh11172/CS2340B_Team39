package com.example.cs2340b_team39;

import android.media.Image;

public class Player {
    private String name;
    private Image avatar;
    private double health;
    private double difficulty;
    // private Weapon equipped;
    // private Ability ability;
    private double score;
    private volatile static Player player;

    private Player(String name, int characterId, double difficulty) {
        this.name = name;
        //this.avatar = avatar;
        this.health = (100 - difficulty * 25);
        this.difficulty = difficulty;
    }

    /*
     *
     * Name: getPlayer()
     * @return the instance of the player
     */
    public static Player getPlayer(String name, int characterId, double difficulty) {
        if (player == null) {
            synchronized (Player.class) {
                if (player == null) {
                    player = new Player(name,characterId,difficulty);
                }
            }
        }
        return player;
    }

    public String getName() {
        return name;
    }
    public Image getAvatar() {
        return avatar;
    }

    public double getHealth() {
        return health;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public void setScore(int val) {
        this.score = val;
    }
    public double getScore(int val) {
        return val;
    }
}