package com.example.cs2340b_team39.Model;

import android.view.View;
import android.widget.ImageView;

import com.example.cs2340b_team39.View.GameActivity;
import com.example.cs2340b_team39.View.GameActivityMap2;
import com.example.cs2340b_team39.View.GameActivityMap3;
import com.example.cs2340b_team39.ViewModel.ViewModel;

public class PlayerMovement implements Movement {
    private static boolean testCase;
    @Override
    public void moveDown(int speed) {
        Player.getPlayer().setPlayerY(Player.getPlayer().getPlayerY() + speed);
        if (checkCollisions()) {
            Player.getPlayer().setPlayerY(Player.getPlayer().getPlayerY() - speed);
        }
    }

    @Override
    public void moveLeft(int speed) {
        Player.getPlayer().setPlayerX(Player.getPlayer().getPlayerX() - speed);
        if (checkCollisions()) {
            Player.getPlayer().setPlayerX(Player.getPlayer().getPlayerX() + speed);
        }
    }

    @Override
    public void moveRight(int speed) {
        Player.getPlayer().setPlayerX(Player.getPlayer().getPlayerX() + speed);
        if (checkCollisions()) {
            Player.getPlayer().setPlayerX(Player.getPlayer().getPlayerX() - speed);
        }
    }

    @Override
    public void moveUp(int speed) {
        Player.getPlayer().setPlayerY(Player.getPlayer().getPlayerY() - speed);
        if (checkCollisions()) {
            Player.getPlayer().setPlayerY(Player.getPlayer().getPlayerY() + speed);
        }
    }
    public boolean checkCollisions() {
        if (testCase) {
            return false;
        }
        int map = ViewModel.checkMap();
        if (map == 1) {
            if (Player.getPlayer().getPlayerX() <= 5) {
                return true;
            }
            if (Player.getPlayer().getPlayerX() >= GameActivity.getWidth() - 25) {
                return true;
            }
            ImageView top = GameActivity.getTop();
            ImageView leftC = GameActivity.getLeftC();
            ImageView rightC = GameActivity.getRightC();
            ImageView bottom = GameActivity.getBottom();
            if (Player.getPlayer().getPlayerY() <= top.getY() + 40) {
                return true;
            }
            if (Player.getPlayer().getPlayerY() <= leftC.getY() + 40
                    && Player.getPlayer().getPlayerX() <= leftC.getX() + 25) {
                return true;
            }
            if (Player.getPlayer().getPlayerY() <= rightC.getY() + 40
                    && Player.getPlayer().getPlayerX() >= rightC.getX() + 25) {
                return true;
            }
            if (Player.getPlayer().getPlayerY() >= bottom.getY() + 40) {
                return true;
            }
        }
        if (map == 2) {
            ImageView top = GameActivityMap2.getTop();
            ImageView bottom = GameActivityMap2.getBottom();
            if (Player.getPlayer().getPlayerX() <= 5) {
                return true;
            }
            if (Player.getPlayer().getPlayerX() >= GameActivity.getWidth() - 25) {
                return true;
            }
            if (Player.getPlayer().getPlayerY() >= bottom.getY() + 40) {
                return true;
            }
            if (Player.getPlayer().getPlayerY() <= top.getY() + 40) {
                return true;
            }
        }
        if (map == 3) {
            ImageView top = GameActivityMap3.getTop();
            ImageView bottom = GameActivityMap3.getBottom();
            ImageView leftC = GameActivityMap3.getLeftC();
            if (Player.getPlayer().getPlayerX() <= 5) {
                return true;
            }
            if (Player.getPlayer().getPlayerX() >= GameActivity.getWidth() - 25) {
                return true;
            }
            if (Player.getPlayer().getPlayerY() >= bottom.getY() + 40) {
                return true;
            }
            if (Player.getPlayer().getPlayerY() <= top.getY() + 40) {
                return true;
            }
            if (Player.getPlayer().getPlayerY() <= leftC.getY() + 40
                    && Player.getPlayer().getPlayerX() <= leftC.getX() + 25) {
                return true;
            }
        }
        return false;
    }
    public static void setTestCase(boolean t) {
        testCase = t;
    }
}
