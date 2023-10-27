package com.example.cs2340b_team39.Model;

public class Enemy {
    private double health;
    private double speed;
    private double damage;
    private double size;
    private double x, y;
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
}
