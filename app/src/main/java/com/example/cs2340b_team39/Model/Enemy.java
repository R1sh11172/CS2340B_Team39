package com.example.cs2340b_team39.Model;

import android.widget.ImageView;

public interface Enemy {
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

    boolean getIsDead();
    void setIsDead(boolean b);
}
