package com.example.cs2340b_team39;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;

import androidx.core.content.res.ResourcesCompat;

public class Player {
    private String name;
    private Drawable avatar;
    private double health;
    private double difficulty;
    // private Weapon equipped;
    // private Ability ability;

    public Player(String name, int characterId, double difficulty) {
        this.name = name;
        this.health = (100 - difficulty * 25);
        this.difficulty = difficulty;
    }

    public String getName() {
        return name;
    }
    public Drawable getAvatar() {
        return avatar;
    }

    public double getHealth() {
        return health;
    }

    public double getDifficulty() {
        return difficulty;
    }
}
