package com.example.cs2340b_team39.Model;

import android.widget.ImageView;

import com.example.cs2340b_team39.View.GameActivity;
import com.example.cs2340b_team39.View.GameActivityMap2;
import com.example.cs2340b_team39.View.GameActivityMap3;
import com.example.cs2340b_team39.ViewModel.ViewModel;

public class EnemyMovement implements Movement {
    private Enemy enemy;
    private boolean testCase;

    public EnemyMovement(Enemy e) {
        this.enemy = e;
    }
    public EnemyMovement() {
        enemy = null;
    }

    public void moveLeft(int speed) {
        enemy.setX(enemy.getX() - speed);
        if (checkCollisions()) {
            enemy.setX(enemy.getX() + speed);
        }
        ViewModel.updateEnemyPosition(enemy);
    }

    public void moveRight(int speed) {
        enemy.setX(enemy.getX() + speed);
        if (checkCollisions()) {
            enemy.setX(enemy.getX() - speed);
        }
        ViewModel.updateEnemyPosition(enemy);
    }

    public void moveUp(int speed) {
        enemy.setY(enemy.getY() - speed);
        if (checkCollisions()) {
            enemy.setY(enemy.getY() + speed);
        }
        ViewModel.updateEnemyPosition(enemy);
    }

    public void moveDown(int speed) {
        enemy.setY(enemy.getY() + speed);
        if (checkCollisions()) {
            enemy.setY(enemy.getY() - speed);
        }
        ViewModel.updateEnemyPosition(enemy);
    }

    public boolean checkCollisions() {
        if (testCase) {
            return false;
        }
        int map = ViewModel.checkMap();
        if (map == 1) {
            if (enemy.getX() <= 5) {
                return true;
            }
            if (enemy.getX() >= GameActivity.getWidth() - 25) {
                return true;
            }
            ImageView top = GameActivity.getTop();
            ImageView leftC = GameActivity.getLeftC();
            ImageView rightC = GameActivity.getRightC();
            ImageView bottom = GameActivity.getBottom();
            if (enemy.getY() <= top.getY() + 40) {
                return true;
            }
            if (enemy.getY() <= leftC.getY() + 40
                    && enemy.getX() <= leftC.getX() + 25) {
                return true;
            }
            if (enemy.getY() <= rightC.getY() + 40
                    && enemy.getX() >= rightC.getX() + 25) {
                return true;
            }
            if (enemy.getY() >= bottom.getY() + 40) {
                return true;
            }
        }
        if (map == 2) {
            ImageView top = GameActivityMap2.getTop();
            ImageView bottom = GameActivityMap2.getBottom();
            if (enemy.getX() <= 5) {
                return true;
            }
            if (enemy.getX() >= GameActivity.getWidth() - 25) {
                return true;
            }
            if (enemy.getY() >= bottom.getY() + 40) {
                return true;
            }
            if (enemy.getY() <= top.getY() + 40) {
                return true;
            }
        }
        if (map == 3) {
            ImageView top = GameActivityMap3.getTop();
            ImageView bottom = GameActivityMap3.getBottom();
            ImageView leftC = GameActivityMap3.getLeftC();
            if (enemy.getX() <= 5) {
                return true;
            }
            if (enemy.getX() >= GameActivity.getWidth() - 25) {
                return true;
            }
            if (enemy.getY() >= bottom.getY() + 40) {
                return true;
            }
            if (enemy.getY() <= top.getY() + 40) {
                return true;
            }
            if (enemy.getY() <= leftC.getY() + 40
                    && enemy.getX() <= leftC.getX() + 25) {
                return true;
            }
        }
        CollisionSub.getCollision().checkPECollision();
        return false;
    }
    public void setEnemy(Enemy e) {
        enemy = e;
    }
    public void setTestCase(boolean test) {
        testCase = test;
    }
}