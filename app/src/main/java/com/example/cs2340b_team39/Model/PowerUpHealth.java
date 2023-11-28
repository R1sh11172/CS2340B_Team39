package com.example.cs2340b_team39.Model;

public class PowerUpHealth extends PowerUpDecorator {
    public PowerUpHealth(PowerUp decoratedPowerUp) {
        super(decoratedPowerUp);
    }

    public void applyPowerUp(Player player) {
        player.increaseHealth(20);
    }
}
