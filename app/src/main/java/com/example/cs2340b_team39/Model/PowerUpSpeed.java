package com.example.cs2340b_team39.Model;

public class PowerUpSpeed extends PowerUpDecorator {
    public PowerUpSpeed(PowerUp decoratedPowerUp) {
        super(decoratedPowerUp);
    }

    public void applyPowerUp(Player player) {
        player.increaseSpeed(10);
    }
}
