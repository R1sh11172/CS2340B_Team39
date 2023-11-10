package com.example.cs2340b_team39.Model;

public class Enemy1 extends Enemy {
    private double health;
    private double speed;
    private double damage;
    private double size;
    private double x;
    private double y;
    private EnemyMovement movement;

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
    public void doubleDamage() {
        damage *= 2;
    }


}
