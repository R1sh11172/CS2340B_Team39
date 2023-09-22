package com.example.cs2340b_team39;

import android.media.Image;

public class Player {
    private String name;
    private Image avatar;
    private double health;
    private double difficulty;
    // private Weapon equipped;
    // private Ability ability;

    public Player(String name, int characterId, double difficulty) {
        this.name = name;
        //this.avatar = avatar;
        this.health = (100 - difficulty * 25);
        this.difficulty = difficulty;
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
}
