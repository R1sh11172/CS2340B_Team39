package com.example.cs2340b_team39;

import android.media.Image;

public class Player {
    private String name;
    private Image avatar;
    private int health;
    // private Weapon equipped;
    // private Ability ability;

    public Player(String name, Image avatar, int difficulty) {
        this.name = name;
        this.avatar = avatar;
        this.health = 100 - difficulty * 25;
    }
}
