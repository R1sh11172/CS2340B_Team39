package com.example.cs2340b_team39.Model;

import android.widget.ImageView;

public interface Enemy {
//    double health;
//    double speed;
//    double damage;
//    double size;
//    double x;
//    double y;
//    ImageView sprite;
//    EnemyMovement movement;
    void setX(double x);
    void setY(double y);
    double getX();
    double getY();
    double getDamage();
    double getSize();
    void movePattern();
    void initMovement();
    ImageView getSprite();
    void setFinished(boolean b);
    void setMovement(EnemyMovement m);
}
