package com.example.cs2340b_team39.Model;

public class PowerUpDecorator implements PowerUp {
    protected PowerUp decoratedPowerUp;

    public PowerUpDecorator(PowerUp decoratedPowerUp) {
        this.decoratedPowerUp = decoratedPowerUp;
    }

    public void applyPowerUp(Player player) {
        decoratedPowerUp.applyPowerUp(player);
    }
}
