package com.example.cs2340b_team39.Model;

public class PowerUpFreeze extends PowerUpDecorator {
    public PowerUpFreeze(PowerUp decoratedPowerUp) {
        super(decoratedPowerUp);
    }

    public void applyPowerUp(Player player) {
        CollisionSub.getCollision().freezeEnemies();
    }
}
