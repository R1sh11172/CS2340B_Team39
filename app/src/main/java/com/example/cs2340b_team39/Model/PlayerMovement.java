package com.example.cs2340b_team39.Model;

import com.example.cs2340b_team39.ViewModel.ViewModel;

public class PlayerMovement implements Movement {
    @Override
    public void moveDown(int speed) {
        Player.getPlayer().setPlayerY(Player.getPlayer().getPlayerY() + speed);
        ViewModel.updatePlayerPosition();
    }

    @Override
    public void moveLeft(int speed) {
        Player.getPlayer().setPlayerX(Player.getPlayer().getPlayerX() - speed);
        ViewModel.updatePlayerPosition();
    }

    @Override
    public void moveRight(int speed) {
        Player.getPlayer().setPlayerX(Player.getPlayer().getPlayerX() + speed);
        ViewModel.updatePlayerPosition();
    }

    @Override
    public void moveUp(int speed) {
        Player.getPlayer().setPlayerY(Player.getPlayer().getPlayerY() - speed);
        ViewModel.updatePlayerPosition();
    }
}
