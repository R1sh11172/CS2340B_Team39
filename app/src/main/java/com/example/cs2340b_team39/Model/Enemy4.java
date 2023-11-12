package com.example.cs2340b_team39.Model;

import android.widget.ImageView;

public class Enemy4 implements Enemy {
    private double health;
    private double speed;
    private double damage;
    private double size;
    private double x;
    private double y;
    private EnemyMovement movement;
    private ImageView sprite;
    public Enemy4(ImageView i) {
        health = 20;
        speed = 20;
        damage = 20;
        size = 16;
        x = i.getX();
        y = i.getY();
        tripleSize();
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getDamage() {
        return damage;
    }
    public double getSize() {
        return size;
    }
    public void tripleSize() {
        size *= 3;
    }
    public void movePattern() {

    }
    public void initMovement() {
        this.movement.setEnemy(this);
    }
}
