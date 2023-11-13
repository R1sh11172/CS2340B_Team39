package com.example.cs2340b_team39.Model;

import android.os.CountDownTimer;
import android.widget.ImageView;

import java.util.LinkedList;
import java.util.Queue;

public class Enemy2 implements Enemy {
    private double health;
    private double speed;
    private double damage;
    private boolean finished;
    private double size;
    private double x;
    private double y;
    private EnemyMovement movement;
    private ImageView sprite;
    public Enemy2(ImageView i) {
        health = 20;
        speed = 20;
        if (Player.getPlayer() != null) {
            damage = Math.pow(2, 1 + Player.getPlayer().getDifficulty());
        }
        size = 50;
        doubleSpeed();
        if (i != null) {
            x = i.getX();
            y = i.getY();
            sprite = i;
        }
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
    public void doubleSpeed() {
        speed *= 2;
    }
    public void movePattern() {
        Queue<Integer> moves = new LinkedList<Integer>();
        //0:up 1:right 2: down 3: left
        moves.add(1);
        moves.add(1);
        moves.add(1);
        moves.add(3);
        moves.add(3);
        moves.add(3);
        new CountDownTimer(300000, 500) {
            public void onTick(long millisUntilFinished) {
                if (!finished) {
                    int next = moves.remove();
                    moves.add(next);
                    switch (next) {
                        case 0:
                            movement.moveUp((int) speed);
                            break;
                        case 1:
                            movement.moveRight((int) speed);
                            break;
                        case 2:
                            movement.moveDown((int) speed);
                            break;
                        case 3:
                            movement.moveLeft((int) speed);
                            break;

                        default:
                            break;
                    }
                }
            }
            public  void onFinish() {
            }
        }.start();
    }
    public void initMovement() {
        this.movement.setEnemy(this);
    }
    public ImageView getSprite() {
        return sprite;
    }
    public void setFinished(boolean b) {
        finished = b;
    }
    public void setMovement(EnemyMovement m) {
        movement = m;
    }
}
