package com.example.cs2340b_team39.Model;

import android.widget.ImageView;

public class Enemy2 implements Enemy {
    private double health;
    private double speed;
    private double damage;
    private double size;
    private double x;
    private double y;
    private EnemyMovement movement;
    public Enemy2(ImageView i) {
        health = 20;
        speed = 20;
        damage = 20;
        size = 16;
        x = i.getX();
        y = i.getY();
        doubleSize();
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
    public void doubleSize() {
        size *= 2;
    }
    public void movePattern() {

    }
    public void initMovement() {
        this.movement.setEnemy(this);
    }

}
